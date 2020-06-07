package app.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static CSVReader instance;

    private CSVReader() {
    }

    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

    public static List<String> readFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String dataRow;
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] row = dataRow.split(",");
                data.add(String.join(",", row));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    //Nu cred ca trebuiau facute urmatoarele:
    public static List<String> readArtistsFromFile(String filePath) {
        ArrayList<String> artists = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String columnName = bufferedReader.readLine();
            artists.add(columnName);
            String dataRow;
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] row = dataRow.split(",");
                String name = row[0];
                String dancers = row[1];
                String guests = row[2];
                String groupPic = row[3];
                artists.add(String.join(",", name, dancers, guests, groupPic));
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return artists;
    }

    public static List<String> readClientsFromFile(String filePath) {
        ArrayList<String> clients = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String columnName = bufferedReader.readLine();
            clients.add(columnName);
            String dataRow;
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] row = dataRow.split(",");
                String name = row[0];
                String email = row[1];
                String age = row[2];
                clients.add(String.join(",", name, email, age));
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return clients;
    }

    public static List<String> readEventsFromFile(String filePath) {
        ArrayList<String> events = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String columnName = bufferedReader.readLine();
            events.add(columnName);
            String dataRow;
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] row = dataRow.split(",");
                String venue = row[0];
                String city = row[1];
                String country = row[2];
                String date = row[3];
                String capacity = row[4];
                String artistName = row[5];
                events.add(String.join(",", venue, city, country, date, capacity, artistName));
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return events;
    }

    public static List<String> readSponsorsFromFile(String filePath) {
        ArrayList<String> sponsors = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String columnName = bufferedReader.readLine();
            sponsors.add(columnName);
            String dataRow;
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] row = dataRow.split(",");
                String name = row[0];
                String sum = row[1];
                sponsors.add(String.join(",", name, sum));
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return sponsors;
    }

}
