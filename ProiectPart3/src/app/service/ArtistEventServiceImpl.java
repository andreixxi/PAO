package app.service;

import app.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArtistEventServiceImpl implements ArtistEventService {

    private List<Artist> artistList = new ArrayList<>();
    private List<Event> eventList = new ArrayList<>();

    public List<Artist> getArtistList() {
        return artistList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    @Override
    public void readArtists() {
        try {
            File data = new File("C:\\Users\\andrei\\Desktop\\ProiectPAO2\\src\\app\\data\\artists.txt");
            Scanner in = new Scanner(data);
            String line = in.nextLine();
            int noArtists = Integer.parseInt(line);
            for (int i = 0; i < noArtists; i++) {
                Artist artist = new Artist();
                line = in.nextLine();
                String[] artistInfo = line.split(" ");
                int len = artistInfo.length;

                String artistName = artistInfo[0];
                artist.setName(artistName);

                boolean dancers = Boolean.parseBoolean(artistInfo[1]);
                artist.setDancers(dancers); //set if the artist has dancers

                boolean guests = Boolean.parseBoolean(artistInfo[2]);
                artist.setGuests(guests);

                boolean groupPic = Boolean.parseBoolean((artistInfo[3]));
                artist.setGroupPic(groupPic);
                // the artist has at least 1 booked date
                if (len > 4) {
                    String[] dates = new String[len - 4]; //3 = name + dancers + guests + groupPic
                    System.arraycopy(artistInfo, 4, dates, 0, len - 4);
                    artist.setBookedDates(dates); //set the booked dates of the artist
                }
                artistList.add(artist);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading artists.");
        }
    }

    @Override
    public void showArtists() {
        System.out.println("There are " + artistList.size() + " artists");
        for (Artist artist : artistList) {
            System.out.println(artist);
        }
    }

    @Override
    public void readEventInfo() {
        try {
            File data = new File("C:\\Users\\andrei\\Desktop\\ProiectPAO2\\src\\app\\data\\event.txt");
            Scanner in = new Scanner(data);
            String line = in.nextLine();
            int noOfEvents = Integer.parseInt(line);
            for (int i = 0; i < noOfEvents; i++) {
                Event event = new Event();
                line = in.nextLine();
                String[] eventInfo = line.split(" ");
                String venue = eventInfo[0];
                String city = eventInfo[1];
                String country = eventInfo[2];
                String date = eventInfo[3];
                int seatingCapacity = Integer.parseInt(eventInfo[4]);
                String artistName = eventInfo[5];

                event.setVenue(venue);
                event.setCity(city);
                event.setCountry(country);
                event.setDate(date);
                event.setSeatingCapacity(seatingCapacity);

                Artist artist = findArtist(artistName); //primesc toate informatiile de la artist
                event.setArtist(artist);

                event.setEventNo(i + 1);

                eventList.add(event);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading events.");
        }
    }

    @Override
    public void showEventInfo() {
        System.out.println("There are " + eventList.size() + " events");
        for (Event event : eventList) {
            System.out.println(event.getEventNo() + " " + event.getArtist().getName() + " " + event.getCity() +
                    " " + event.getCountry() + " " + event.getVenue() + " " + event.getDate());
        }
    }

    @Override
    public Artist findArtist(String name) {
        for (Artist artist : artistList) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }
        return null;
    }

    @Override
    public boolean doEvent(List<Sponsor> sponsorList, List<Ticket> ticketList, Organiser organiser) {
        float sum = 0;
        //money from sponsors
        for (int i = 0; i < sponsorList.size(); i++) {
            sum += sponsorList.get(i).getSum();
        }

        //tickets sale
        for (int i = 0; i < ticketList.size(); i++) {
            float price = ticketList.get(i).getPrice();
            sum += ticketList.get(i).priceCalc(price);
        }

        //the event is cancelled if the necessary costs are higher than the sum obtained from tickets sale and sponsors
        return (organiser.getEventBudget() <= sum);
    }

    @Override
    public String toString() {
        return "eventList=" + eventList +
                ", artistList=" + artistList;
    }

    /*
    public void delEvent() {
        //if the event has to be cancelled we remove it from the list of events
        eventList.removeIf(event -> !doEvent(this.getSponsors(), this.getTickets(), this.getOrganisers()));
    }*/

}
