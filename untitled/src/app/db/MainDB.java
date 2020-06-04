package app.db;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class MainDB {
    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3306/appdb";
        String username = "root";
        String pass = "parola";
        System.out.println("Enter an option \n 1. Add an artist  \n 2. Show artists\n 3. Update artist info\n" + " 4. Delete an artist \n " +
                "5. Add a client \n 6. Show clients that have bought tickets \n 7. Update client's data \n" + " 8. Delete a client \n " +
                "9. Add an event \n 10. Show events \n 11. Update an event info \n " + "12. Delete an event  \n " +
                "13. Add a sponsor \n 14. Show sponsors \n 15. Update a sponsor\n " + "16. Delete a sponsor \n " +
                "17. Exit");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option != 17) {
            switch (option) {
                case 1: {
                    ArtistDB.addArtist(host, username, pass);
                    break;
                }
                case 2: {
                    System.out.println(ArtistDB.showArtists(host, username, pass));
                    break;
                }
                case 3: {
                    ArtistDB.updateArtist(host, username, pass);
                    break;
                }
                case 4: {
                    ArtistDB.deleteArtist(host, username, pass);
                    break;
                }
                case 5: {
                    ClientDB.addClient(host, username, pass);
                    break;
                }
                case 6: {
                    System.out.println(ClientDB.showClients(host, username, pass));
                    break;
                }
                case 7: {
                    ClientDB.updateClient(host, username, pass);
                    break;
                }
                case 8: {
                    ClientDB.deleteClient(host, username, pass);
                    break;
                }
                case 9: {
                    EventDB.addEvent(host, username, pass);
                    break;
                }
                case 10: {
                    System.out.println(EventDB.showEvents(host, username, pass));
                    break;
                }
                case 11: {
                    EventDB.updateEvent(host, username, pass);
                    break;
                }
                case 12: {
                    EventDB.deleteEvent(host, username, pass);
                    break;
                }
                case 13: {
                    SponsorDB.addSponsor(host, username, pass);
                    break;
                }
                case 14: {
                    System.out.println(SponsorDB.showSponsors(host, username, pass));
                    break;
                }
                case 15: {
                    SponsorDB.updateSponsor(host, username, pass);
                    break;
                }
                case 16: {
                    SponsorDB.deleteSponsor(host, username, pass);
                    break;
                }
                default: {
                    System.out.println("Option is invalid ");
                    break;
                }
            }
            System.out.println("Enter an option \n 1. Add an artist  \n 2. Show artists\n 3. Update artist info\n" + " 4. Delete an artist \n " +
                    "5. Add a client \n 6. Show clients that have bought tickets \n 7. Update client's data \n" + " 8. Delete a client \n " +
                    "9. Add an event \n 10. Show events \n 11. Update an event info \n " + "12. Delete an event  \n " +
                    "13. Add a sponsor \n 14. Show sponsors \n 15. Update a sponsor " + "16. Delete a sponsor \n " +
                    "17. Exit");
            option = scanner.nextInt();
        }
    }

    public static void write(String function) {
        //write in the audit service
        try {
            FileWriter fw = new FileWriter(new File("output.csv"), true);
            java.util.Date d = new Date();
            //getTime() returns current time in milliseconds
            long t = d.getTime();
            //Passed the milliseconds to constructor of Timestamp class
            Timestamp ts = new Timestamp(t);
            String currentThreadName = Thread.currentThread().getName();
            fw.write(function + "," + ts.toString() + "," +currentThreadName + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
