package app;

import app.util.CSVReader;
import app.util.Services;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Date date = new Date(); //data curenta
        Services.read(); // citire toate datele .csv

        List<String> values = new ArrayList<>();
        values.add(String.join(",", "Citire CSV", date.toString()));
        Services.auditService(values);

        boolean exit = false;
        while (!exit) {
            System.out.println("Pick your option");
            Services.menu();
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();

            switch (ans) {
                case 1: { // show artists
                    List<String> artists = CSVReader.readFromFile("artistData.csv");
                    Services.show(artists);
                    date = Calendar.getInstance().getTime();
                    values.add(String.join(",", "Afisare artisti", date.toString()));
                    Services.auditService(values); // scriere in audit
                    break;
                }
                case 2 : {
                    List<String> events = CSVReader.readFromFile("eventData.csv");
                    Services.show(events);
                    date = Calendar.getInstance().getTime();
                    values.add(String.join(",", "Afisare evenimente", date.toString()));
                    Services.auditService(values);
                    break;
                }
                case 3 : {
                    List<String> sponsors = CSVReader.readFromFile("sponsorData.csv");
                    Services.show(sponsors);
                    date = Calendar.getInstance().getTime();
                    values.add(String.join(",", "Afisare sponsori", date.toString()));
                    Services.auditService(values);
                    break;
                }
                case 4 : {
                    List<String> clients = CSVReader.readFromFile("clientData.csv");
                    Services.show(clients);
                    date = Calendar.getInstance().getTime();
                    values.add(String.join(",", "Afisare clienti", date.toString()));
                    Services.auditService(values);
                    break;
                }
                case 5: {
                    exit = true;
                    date = Calendar.getInstance().getTime();
                    values.add(String.join(",", "Exit", date.toString()));
                    Services.auditService(values);
                    scanner.close();
                    break;
                }
                default:
                    break;
            } // end switch
        } // end while

    }
}
