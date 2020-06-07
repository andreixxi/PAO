package app.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SponsorDB {
    public static void addSponsor(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);

            String sql = "select max(sponsor_id) from sponsor;"; // gets the latest id
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int id = -1;
            if (resultSet.next()) {
                //Retrieve by column name
                id = resultSet.getInt("max(sponsor_id)");
            }
            id++;
            String event_id = String.valueOf(id);
            System.out.println("Adding sponsor...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter sponsor's name.");
            String name = in.next();
            System.out.println("Enter sponsor's sum.");
            float sum = in.nextFloat();
            sql = "insert into sponsor (sponsor_id, sponsor_name, sum) VALUES (?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setFloat(3, sum);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new sponsor was inserted successfully!");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        MainDB.write("addSponsor");
    }

    public static ArrayList<String> showSponsors(String host, String username, String password) {
//        String sponsors = "";
        ArrayList<String> sponsors = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            String sql = "select * from sponsor";
            //Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String artists = "";
            while (resultSet.next()) { //extract data
                int id = resultSet.getInt("sponsor_id");
                String name = resultSet.getString("sponsor_name");
                float sum = resultSet.getFloat("sum");

//                System.out.println(id + ". sponsor: " + name + ", " + "sum:" + sum);
                sponsors.add(id + ". sponsor: " + name + ", " + "sum:" + sum);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        MainDB.write("showSponsors");
        return sponsors;
    }

    public static void updateSponsor(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);

            System.out.println("Updating sponsor...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter sponsor's id.");
            int id = in.nextInt();
            System.out.println("Enter sponsor's name.");
            String name = in.next();
            System.out.println("Enter sponsor's sum.");
            float sum = in.nextFloat();

            //update query
            String sql = "update appdb.sponsor set sponsor_name = ?, sum = ? where sponsor_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setFloat(2, sum);
            preparedStatement.setInt(3, id);

            //execute
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Sponsor " + id + " was updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MainDB.write("updateSponsor");
    }

    public static void deleteSponsor(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the sponsor's id you want to delete from the database.");
            int id = in.nextInt();
            String sql = "delete from appdb.sponsor where sponsor_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Sponsor " + id + " was deleted from the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MainDB.write("deleteSponsor");
    }
}
