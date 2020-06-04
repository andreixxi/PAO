package app;

import app.model.Artist;
import app.model.Client;
import app.model.Event;
import app.service.ArtistEventServiceImpl;
import app.util.Services;

import java.util.ArrayList;
import java.util.List;

public class CreateCSVFiles {

    public static void main(String[] args) {

        ArtistEventServiceImpl a = new ArtistEventServiceImpl();
        a.readArtists(); // citire artisti si evenimente
        List<Artist> artistList = a.getArtistList();
        Services helper = new Services(); // obiect cu care scriu fisiere csv

        List<ArrayList<String>> data = new ArrayList<>(); // lista de liste
        String columnNames = "Name,Dancers,Guests,Picture\n";
        // scriere artisti in fisier csv
        for (int i = 0; i < artistList.size(); i++) {
            Artist artist = artistList.get(i); // artistul de pe pozitia i
            ArrayList<String> values = new ArrayList<>();

            // extrag datele
            String name = artist.getName();
            String dancers = Boolean.toString(artist.isDancers());
            String guests = Boolean.toString(artist.isGuests());
            String groupPic = Boolean.toString(artist.isGroupPic());

            values.add(String.join(",", name, dancers, guests, groupPic)); // le separ prin virgula in lista de stringuri
            data.add(i, values); // adaug pe linia i
        }
        helper.createCSVFile(columnNames, data, "artistData.csv");
        data.clear();

        // scriere pentru evenimente
        a.readEventInfo(); // citire evenimente
        List<Event> eventList = a.getEventList();
        columnNames = "Venue,City,Country,Date,Capacity,Artist\n";

        for (int i = 0; i < eventList.size(); i++) {
            Event event = eventList.get(i);
            ArrayList<String> values = new ArrayList<>();

            String venue = event.getVenue();
            String city = event.getCity();
            String country = event.getCountry();
            String date = event.getDate();
            String capacity = Integer.toString(event.getSeatingCapacity());
            String artistName = event.getArtist().getName();

            values.add(String.join(",", venue, city, country, date, capacity, artistName));
            data.add(i, values);
        }
        helper.createCSVFile(columnNames, data, "eventData.csv");
        data.clear();

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mircea Alex", "mirceaalex@yahoo.com", 24));
        clients.add(new Client("John Brown", "jbrown@gmail.com", 19));
        clients.add(new Client("Popa Eleonora", "pelena@yahoo.com", 20));

        columnNames = "Name,Email,Age\n";
        for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);
            ArrayList<String> values = new ArrayList<>();
            String name = c.getName();
            String email = c.getEmail();
            String age = Integer.toString(c.getAge());
            values.add(String.join(",", name, email, age));
            data.add(i, values);
        }
        helper.createCSVFile(columnNames, data, "clientData.csv");
        data.clear();

    }
}
