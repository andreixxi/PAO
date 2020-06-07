package app.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtistDB {

    public static void addArtist(String host, String username, String password) {
        try {

            Connection connection = DriverManager.getConnection(host, username, password);

            String sql = "select max(artist_id) from artist;"; // gets the latest id
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int id = -1;
            if (resultSet.next()) {
                //Retrieve by column name
                id = resultSet.getInt("max(artist_id)");
            }
            id++;
            String artist_id = String.valueOf(id);
            System.out.println("Adding artist...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter artist's name.");
            String artistName = in.nextLine();
            System.out.println("Enter 1 if the artist has dancers, 0 otherwise.");
            String dancers = in.nextLine();
            System.out.println("Enter 1 if the artist has guests, 0 otherwise.");
            String guests = in.nextLine();
            System.out.println("Enter 1 if the artist allows group picture, 0 otherwise.");
            String groupPic = in.nextLine();

            sql = "insert into artist (artist_id, artist_name, artist_dancers, artist_guests, artist_groupPic) VALUES (?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, artist_id);
            preparedStatement.setString(2, artistName);
            preparedStatement.setString(3, dancers);
            preparedStatement.setString(4, guests);
            preparedStatement.setString(5, groupPic);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new artist was inserted successfully!");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        MainDB.write("addArtist");
    }


    public static ArrayList<String> showArtists(String host, String username, String password) {
        ArrayList<String> artists = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            String sql = "select * from artist";
            //Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { //extract data
                int id = resultSet.getInt("artist_id");
                String name = resultSet.getString("artist_name");
                int dancers = resultSet.getInt("artist_dancers");
                int guests = resultSet.getInt("artist_guests");
                int pic = resultSet.getInt("artist_groupPic");
                String ansD, ansG, ansP = "";
                if (dancers == 1) ansD = "yes";
                else ansD = "no";
                if (guests == 1) ansG = "yes";
                else ansG = "no";
                if (pic == 1) ansP = "yes";
                else ansP = "no";
                artists.add(id + "." + name + ", dancers: " + ansD + ", guests: " + ansG + ", group picture: " + ansP);
            }
//            System.out.println(artists);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        MainDB.write("showArtists");
        return artists;
    }

    public static void updateArtist(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);

            System.out.println("Updating artist...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter artist's id.");
            int id = in.nextInt();
            System.out.println("Enter artist's name.");
            String name = in.next();
            System.out.println("Enter 1 if the artist has dancers, 0 otherwise.");
            int dancers = in.nextInt();
            System.out.println("Enter 1 if the artist has guests, 0 otherwise.");
            int guests = in.nextInt();
            System.out.println("Enter 1 if the artist allows group picture, 0 otherwise.");
            int pic = in.nextInt();

            //update query
            String sql = "update appdb.artist set artist_name = ?, artist_dancers = ?, artist_guests = ?, artist_groupPic = ? where artist_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, dancers);
            preparedStatement.setInt(3, guests);
            preparedStatement.setInt(4, pic);
            preparedStatement.setInt(5, id);

            //execute
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Artist " + id + " was updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MainDB.write("updateArtist");
    }

    public static void deleteArtist(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);

            Scanner in = new Scanner(System.in);
            System.out.println("Enter the artist's id you want to delete from the database.");
            int id = in.nextInt();
            String sql = "delete from appdb.artist where artist_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Artist " + id + " was deleted from the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        MainDB.write("deleteArtist");
    }
}
