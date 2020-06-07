package app.gui;

import app.db.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyGui implements ActionListener {

    JButton button1 = new JButton("Show artists");
    JButton button2 = new JButton("Show events");
    JButton button3 = new JButton("Show sponsors");
    JButton button4 = new JButton("Show clients");
    JButton button5 = new JButton("Buy a ticket");

    public MyGui() {
        //top level container
        JFrame window = new JFrame("Events");
        window.setSize(700, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        JLabel label = new JLabel("Welcome!", SwingConstants.CENTER);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        label.setForeground(Color.blue);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);

        window.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        new MyGui();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String host = "jdbc:mysql://localhost:3306/appdb";
        String username = "root";
        String pass = "parola";

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setLayout(new GridLayout(0, 1));

        //get the list of wanted objects from the database (DB.showSomething) and then add them on a panel on a new window

        if (actionEvent.getSource() == button1) {
            frame.setTitle("Artists");
            ArrayList<String> artists = ArtistDB.showArtists(host, username, pass);
            for (String artist : artists) {
                JLabel label = new JLabel(artist);
                panel.add(label);
            }
            frame.add(panel, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }

        if (actionEvent.getSource() == button2) {
            frame.setTitle("Events");
            ArrayList<String> events = EventDB.showEvents(host, username, pass);
            for (String e : events) {
                JLabel label = new JLabel(e);
                panel.add(label);
            }
            frame.add(panel, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }

        if (actionEvent.getSource() == button3) {
            frame.setTitle("Sponsors");
            ArrayList<String> sponsors = SponsorDB.showSponsors(host, username, pass);
            for (String s : sponsors) {
                JLabel label = new JLabel(s);
                panel.add(label);
            }
            frame.add(panel, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }

        if (actionEvent.getSource() == button4) {
            frame.setTitle("Clients");
            ArrayList<String> clients = ClientDB.showClients(host, username, pass);
            for (String c : clients) {
                JLabel label = new JLabel(c);
                panel.add(label);
            }
            frame.add(panel, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }

        //calculate the ticket price for the chosen artist
        if (actionEvent.getSource() == button5) {
            frame.setTitle("Buy ticket");
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                panel = new JPanel();
                panel.add(new JLabel("Please choose an artist:"));
                DefaultComboBoxModel choices = new DefaultComboBoxModel();
                //sql query
                Connection connection = DriverManager.getConnection(host, username, pass);
                String sql = "select * from artist;";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                List<Object> data = new ArrayList<Object>();
                while (resultSet.next()) { //extract data
                    int id = resultSet.getInt("artist_id");
                    String name = resultSet.getString("artist_name");
                    int dancers = resultSet.getInt("artist_dancers");
                    int guests = resultSet.getInt("artist_guests");
                    int pic = resultSet.getInt("artist_groupPic");
                    data.add(id + name + dancers + guests + pic);
                    choices.addElement(id + "." + name);
                }
                JComboBox comboBox = new JComboBox(choices);
                panel.add(comboBox);
                int result = JOptionPane.showConfirmDialog(null, panel, "Choose Artist", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
//                    System.out.println("You selected " + comboBox.getSelectedItem());
                    int artist_id = comboBox.getSelectedItem().toString().charAt(0); // artist_id ASCII
                    artist_id = Character.getNumericValue(artist_id); //artist_id INT
                    JPanel pricePanel = new JPanel();
                    panel.add(pricePanel);
                    pricePanel.add(new JLabel("Choose the type of ticket you want to purchase."));
                    DefaultComboBoxModel prices = new DefaultComboBoxModel();
                    for (Object datum : data) { //search for the chosen artist and calculate the price
                        int id = datum.toString().charAt(0);
                        id = Character.getNumericValue(id); //current artist_id
                        if (artist_id == id) {
                            int len = datum.toString().length();
                            int pic = Character.getNumericValue(datum.toString().charAt(len - 1)); // ascii to int
                            int guests = Character.getNumericValue(datum.toString().charAt(len - 2));
                            int dancers = Character.getNumericValue(datum.toString().charAt(len - 3));
                            float stdPrice = priceCalc('s', dancers, guests, pic);
                            float vipPrice = priceCalc('v', dancers, guests, pic);
                            prices.addElement("vip " + vipPrice);
                            prices.addElement("standard " + stdPrice);
                            JComboBox pricesBox = new JComboBox(prices);
                            pricePanel.add(pricesBox);
                            int res = JOptionPane.showConfirmDialog(null, panel, "Choose ticket", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (res == JOptionPane.OK_OPTION) {
//                                System.out.println("You selected " + pricesBox.getSelectedItem());
                                JOptionPane.showConfirmDialog(null, "Click ok to confirm", "Confirm purchase", JOptionPane.OK_CANCEL_OPTION);
                            }
                        }
                    }
                }
            } catch (SQLException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            MainDB.write("buy a ticket");
        }
    }

    public float priceCalc(char ticketType, int dancers, int guests, int pic) {
        // if calculates a ticket price given the ticket type and extra stuff(dancers, guests, group pic)
        float fee = 0, price = 0;
        int dancersFee, guestsFee, groupPic = 0;

        if (ticketType == 's') { //standard
            price = 80f;
            fee = 0.08f * price;
            dancersFee = (dancers == 1) ? 7 : 0;
            guestsFee = (guests == 1) ? 10 : 0;
            price = price + fee + dancersFee + guestsFee;
        } else if (ticketType == 'v') { //vip
            price = 135f;
            fee = 0.13f * price;
            dancers = (dancers == 1) ? 9 : 0;
            guests = (guests == 1) ? 12 : 0;
            groupPic = (pic == 1) ? 5 : 0;
            price = price + fee + dancers + guests + groupPic;
        }
        return price;
    }
}
