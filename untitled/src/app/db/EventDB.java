package app.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EventDB {

    public static void addEvent(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);

            String sql = "select max(event_id) from event;"; // gets the latest id
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int id = -1;
            if (resultSet.next()) {
                //Retrieve by column name
                id = resultSet.getInt("max(event_id)");
            }
            id++;
            String event_id = String.valueOf(id);
            System.out.println("Adding event...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter event's venue.");
            String venue = in.nextLine();
            System.out.println("Enter event's city.");
            String city = in.nextLine();
            System.out.println("Enter event's country.");
            String country = in.nextLine();
            System.out.println("Enter event's date.");
            String date = in.nextLine();
            System.out.println("Enter event's capacity.");
            int capacity = in.nextInt();
            System.out.println("Enter artist's name.");
            String artist = in.next();
            System.out.println("Enter organiser's name.");
            String organiser = in.next();
            System.out.println("Enter sponsor's name.");
            String sponsor = in.next();
            sql = "insert into event (event_id, venue, city, country, date, capacity, artist_name, organiser, sponsor) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, event_id);
            preparedStatement.setString(2, venue);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, date);
            preparedStatement.setInt(6, capacity);
            preparedStatement.setString(7, artist);
            preparedStatement.setString(8, organiser);
            preparedStatement.setString(9, sponsor);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new event was inserted successfully!");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        MainDB.write("addEvent");
    }

    public static ArrayList<String> showEvents(String host, String username, String password) {
        ArrayList<String> events = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            String sql = "select * from event";
            //Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String artists = "";
            while (resultSet.next()) { //extract data
                int id = resultSet.getInt("event_id");
                String venue = resultSet.getString("venue");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                String date = resultSet.getString("date");
                int capacity = resultSet.getInt("capacity");
                String artist = resultSet.getString("artist_name");
                String organisers = resultSet.getString("organiser");
                String sponsors = resultSet.getString("sponsor");

//                System.out.println(id + ". " + artist + "@ " + venue + ", " + city + ", " + country + ", "
//                        + date + ", " + capacity + ", " + organisers + ", " + sponsors);
                events.add(id + ". " + artist + "@ " + venue + ", " + city + ", " + country + ", "
                        + date + ", " + capacity + ", " + organisers + ", " + sponsors);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        MainDB.write("showEvents");
        return events;
    }

    public static void updateEvent(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);

            System.out.println("Updating event...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter event's id.");
            int id = in.nextInt();
            System.out.println("Enter event's venue.");
            String venue = in.next();
            System.out.println("Enter event's city.");
            String city = in.next();
            System.out.println("Enter event's date.");
            String date = in.next();
            System.out.println("Enter event's capacity.");
            int capacity = in.nextInt();
            System.out.println("Enter artist's name.");
            String artist = in.next();

            //update query
            String sql = "update appdb.event set venue = ?, city = ?, date = ?, capacity = ?, artist_name = ? where event_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, venue);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, date);
            preparedStatement.setInt(4, capacity);
            preparedStatement.setString(5, artist);
            preparedStatement.setInt(6, id);

            //execute
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Event " + id + " was updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MainDB.write("updateEvent");
    }

    public static void deleteEvent(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the event's id you want to delete from the database.");
            int id = in.nextInt();
            String sql = "delete from appdb.event where event_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Event " + id + " was deleted from the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MainDB.write("deleteEvent");
    }
}
