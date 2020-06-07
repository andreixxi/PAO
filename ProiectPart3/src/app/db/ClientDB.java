package app.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientDB {

    public static void addClient(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            String sql = "select max(client_id) from client;"; // gets the latest id
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Integer id = -1;
            if (resultSet.next()) {
                //Retrieve by column name
                id = resultSet.getInt("max(client_id)");
            }
            id++;
            String clientID = String.valueOf(id);
            System.out.println("Adding client...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter client's name.");
            String name = in.nextLine();
            System.out.println("Enter client's email");
            String email = in.nextLine();
            System.out.println("Enter client's age.");
            int age = in.nextInt();

            sql = "insert into client (client_id, client_name, client_email, client_age) values (?, ?, ?, ?)";
            // create the mysql insert prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clientID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, age);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new client was inserted successfully!");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MainDB.write("addClient");
    }

    public static ArrayList<String> showClients(String host, String username, String password) {
        ArrayList<String> clients = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            String sql = "select * from client";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("client_id");
                String name = resultSet.getString("client_name");
                String email = resultSet.getString("client_email");
                int age = resultSet.getInt("client_age");

//                System.out.println(id + "." + name + ", email:" + email + ", " + age + " years");
                clients.add(id + "." + name + ", email:" + email + ", " + age + " years");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MainDB.write("showClients");
        return clients;
    }

    public static void updateClient(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            System.out.println("Updating client...");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter client's id.");
            int id = in.nextInt();
            System.out.println("Enter client's name.");
            String name = in.next();
            System.out.println("Enter client's email.");
            String email = in.next();
            System.out.println("Enter client's age.");
            int age = in.nextInt();

            //update query
            String sql = "update appdb.client set client_name = ?, client_email = ?, client_age = ? where client_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, id);

            //execute
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Client " + id + " was updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MainDB.write("updateClient");
    }

    public static void deleteClient(String host, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the client's id you want to delete from the database.");
            int id = in.nextInt();
            String sql = "delete from appdb.client where client_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Client " + id + " was deleted from the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MainDB.write("deleteClient");
    }
}