package app;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test implements Service {

    private List<Event> eventList = new ArrayList<>();
    private List<Artist> artistList = new ArrayList<>();
    private List<Organiser> organiserList = new ArrayList<>();
    private List<Sponsor> sponsorList = new ArrayList<>();
    private List<Ticket> tickets; //tickets sold
    private float[] ticketPrices;

    public Test() {
        ticketPrices = new float[2];
    }
//    public void addEvent(Event event) {
//        eventList.add(event);
//    }

    public Sponsor[] getSponsors() {
        return this.getSponsors();
    }

    public Ticket[] getTickets() {
        return this.getTickets();
    }

    public Organiser getOrganisers() {
        return this.getOrganisers();
    }

    /*
    public void delEvent() {
        //if the event has to be cancelled we remove it from the list of events
        eventList.removeIf(event -> !doEvent(this.getSponsors(), this.getTickets(), this.getOrganisers()));
    }*/

    @Override
    public String toString() {
        return "eventList=" + eventList +
                ", artistList=" + artistList;
    }

//    public void addTicket(int idx, Ticket ticket) {
//        this.eventList.get(idx).getTickets().add(ticket);
//    }

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

    public void showArtists() {
        System.out.println("There are " + artistList.size() + " artists");
        for (Artist artist : artistList) {
            System.out.println(artist);
        }
    }

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

                Artist artist = findArtist(artistName);
                event.setArtist(artist);

                event.setEventNo(i + 1);

                eventList.add(event);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading events.");
        }
    }

    public void showEventInfo() {
        System.out.println("There are " + eventList.size() + " events");
        for (Event event : eventList) {
            System.out.println(event.getEventNo() + " " + event.getArtist().getName() + " " + event.getCity() +
                    " " + event.getCountry() + " " + event.getVenue() + " " + event.getDate());
        }
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public List<Organiser> getOrganiserList() {
        return organiserList;
    }

    public List<Sponsor> getSponsorList() {
        return sponsorList;
    }

    public float[] getTicketPrices() {
        return ticketPrices;
    }

    @Override
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
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

    public Artist findArtist(String name) {
        for (Artist artist : artistList) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }
        return null;
    }

    public void readOrganisers() {
        try {
            File data = new File("C:\\Users\\andrei\\Desktop\\ProiectPAO2\\src\\app\\data\\organisers.txt");
            Scanner in = new Scanner(data);
            String line = in.nextLine();
            int noOrganisers = Integer.parseInt(line);
            for (int i = 0; i < noOrganisers; i++) {
                line = in.nextLine();
                String[] organiserInfo = line.split(" ");
                String organiserName = organiserInfo[0];
                float sum = Float.parseFloat(organiserInfo[1]);
                Organiser organiser = new Organiser();
                organiser.setName(organiserName);
                organiser.setEventBudget(sum);
                organiserList.add(organiser);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading organisers' info.");
        }
    }

    public void showOrganisers() {
        System.out.println("The sum each organiser needs for the event: ");
        for (Organiser organiser : organiserList) {
            System.out.println(organiser);
        }
    }

    public void readSponsors() {
        try {
            File data = new File("C:\\Users\\andrei\\Desktop\\ProiectPAO2\\src\\app\\data\\sponsors.txt");
            Scanner in = new Scanner(data);
            String line = in.nextLine();
            int noSponsors = Integer.parseInt(line);
            for (int i = 0; i < noSponsors; i++) {
                line = in.nextLine();
                String[] sponsorInfo = line.split(" ");
                String sponsorName = sponsorInfo[0];
                float sum = Float.parseFloat(sponsorInfo[1]);
                Sponsor sponsor = new Sponsor();
                sponsor.setName(sponsorName);
                sponsor.setSum(sum);
                sponsorList.add(sponsor);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading sponsors.");
        }
    }

    public void showSponsors() {
        System.out.println("The sum each sponsor uses for the event: ");
        for (Sponsor sponsor : sponsorList) {
            System.out.println(sponsor);
        }
    }

    public void readTicketPrices() {
        try {
            File data = new File("C:\\Users\\andrei\\Desktop\\ProiectPAO2\\src\\app\\data\\ticketPrices.txt");
            Scanner in = new Scanner(data);
            String line = in.nextLine();
            String[] numbers = line.split(" ");
            float priceStd = Float.parseFloat(numbers[0].trim());
            float priceVip = Float.parseFloat(numbers[1].trim());
            ticketPrices[0] = priceStd;
            ticketPrices[1] = priceVip;
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading tickets' prices");
        }
    }

    public void priceCalc(Artist artist) {
        Ticket ticket = new StandardTicket(null, null, ticketPrices[0], 0, null, artist);
        float newPrice = ticket.priceCalc(ticketPrices[0]);
        ticketPrices[0] = newPrice; //standard ticket

        ticket = new VipTicket(null, null, ticketPrices[0], 0, null, artist);
        newPrice = ticket.priceCalc(ticketPrices[1]);
        ticketPrices[1] = newPrice; //vip ticket
    }

    public void showTicketPrices() {
        System.out.println("The standard ticket is: " + ticketPrices[0] + " and the vip ticket is: " + ticketPrices[1]);
    }
}
