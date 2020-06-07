package app.gui;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3306/appdb";
        String username = "root";
        String pass = "parola";

        try {
            Connection connection = DriverManager.getConnection(host, username, pass);
            String sql = "select * from artist;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Object> objects = new ArrayList<Object>();
            while (resultSet.next()) { //extract data
                int id = resultSet.getInt("artist_id");
                String name = resultSet.getString("artist_name");
                int dancers = resultSet.getInt("artist_dancers");
                int guests = resultSet.getInt("artist_guests");
                int pic = resultSet.getInt("artist_groupPic");

                objects.add(id + name + dancers + guests + pic);
            }
            System.out.println(objects.get(0));
            System.out.println(objects.get(0).toString().charAt(0)); //id
            int len = objects.get(0).toString().length();
            System.out.println(objects.get(0).toString().charAt(len - 1)); //pic
            System.out.println(objects.get(0).toString().charAt(len - 2)); //guests
            System.out.println(objects.get(0).toString().charAt(len - 3)); //dancers
            System.out.println(objects.get(0).toString().substring(1, len - 3));

            for (Object object : objects) {
                System.out.println(object);
            }
            String query = "select artist_dancers, artist_guests, artist_groupPic from artist where artist_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(2));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) { //extract data
                int dancers = rs.getInt("artist_dancers");
                int guests = rs.getInt("artist_guests");
                int pic = rs.getInt("artist_groupPic");
                System.out.println(dancers + guests + pic);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
