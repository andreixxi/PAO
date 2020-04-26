package app.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Services {

    CSVReader csvReader;
    CSVWriter csvWriter;

    public Services() {
        this.csvReader = CSVReader.getInstance();
        this.csvWriter = CSVWriter.getInstance();
    }

    public static void read() {
        // citesc din fisier
        List<String> artists = CSVReader.readFromFile("artistData.csv");
        List<String> events = CSVReader.readFromFile("eventData.csv"); // evenimentele
        List<String> clients = CSVReader.readFromFile("clientData.csv"); // clientii(cumparatorii de bilete)
        List<String> sponsors = CSVReader.readFromFile("sponsorData.csv"); // sponsorii
    }

    public static void auditService(List<String> values) {
        CSVWriter.writeToFile(values);
    }

    public static void menu() {
        System.out.println("1.Show artists");
        System.out.println("2.Show events");
        System.out.println("3.Show sponsors");
        System.out.println("4.Show clients");
        System.out.println("5.Exit");
    }
    public static void show(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void createCSVFile(String columnNames, List<ArrayList<String>> values, String filePath) {
        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter(filePath);
            csvWriter.append(columnNames);

            for (List<String> rowData : values) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
