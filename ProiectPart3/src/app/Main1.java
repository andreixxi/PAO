package app;

import app.model.Artist;
import app.model.Client;
import app.model.Person;
import app.model.Sort;
import app.service.ArtistEventServiceImpl;
import app.service.OrganiserServiceImpl;
import app.service.SponsorServiceImpl;
import app.service.TicketServiceImpl;

import java.util.Collections;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        TicketServiceImpl t = new TicketServiceImpl();
        t.readTicketPrices(); // citire preturi bilete;
        t.showTicketPrices(); // afisare preturi bilete

        ArtistEventServiceImpl a = new ArtistEventServiceImpl();
        a.readArtists(); // citire artisti
        System.out.println("Before sorting the artists' names:");
        a.showArtists(); //afisare artisti

        Collections.sort(a.getArtistList(), new Sort()); // sortare (alfabetica)
        System.out.println("After sorting the artists' names:");
        a.showArtists();

        OrganiserServiceImpl o = new OrganiserServiceImpl();
        o.readOrganisers(); // citire organizatori
        o.showOrganisers(); // afisare

        SponsorServiceImpl s = new SponsorServiceImpl();
        s.readSponsors(); // citire sponsori
        s.showSponsors(); // afisare sponsori

        a.readEventInfo(); // citire event
        a.showEventInfo(); // afisare

        Person client = new Client("clientName", "name@domain.com", 15);
        System.out.println(client);

        Scanner scanner = new Scanner(System.in);
        int eventNo = -1;
        boolean rasp_valid = false;
        while (!rasp_valid) {
            a.showEventInfo();
            System.out.println("Choose the event you want to attend. Type its number.");
            eventNo = scanner.nextInt();
            if (eventNo > 0 && eventNo <= a.getEventList().size()) {
                rasp_valid = true;
            } else {
                System.out.println("Please try again.");
            }
        }

        rasp_valid = false;
        int seat = 0;
        Artist artist = a.getEventList().get(eventNo - 1).getArtist(); //the artist the user chose to go to
        t.priceCalc(artist); //add the extra fees
        String ticketType = "";

        while (!rasp_valid) {
            System.out.println("Choose the type of ticket you want to purchase. Press s for standard ticket, v for vip ticket.");
            System.out.println("The tickets prices are: ");
            t.showTicketPrices();
            ticketType = scanner.next().toLowerCase();
            if (ticketType.equals("s") || ticketType.equals("v")) {
                rasp_valid = true;
            } else {
                System.out.println("Please try again.");
            }
        }

        rasp_valid = false;
        float price = -1;
        String ticketName = "";
        int noTickets = -1;
        while (!rasp_valid) {
            if (ticketType.equals("s")) {
                price = t.getTicketPrices()[0];
                ticketName = "Standard ticket";
            } else {
                price = t.getTicketPrices()[1];;  //for a vip ticket
                ticketName = "VIP ticket";
            }
            System.out.println("You chose a " + ticketName + ". You have to pay " + price);
            System.out.println("How many tickets do you want to purchase? ");
            noTickets = scanner.nextInt();
            if (noTickets > 0) {
                // TODO adaug in lista de bilete noTickets bilete + calculez pretul in total
                rasp_valid = true;
            } else {
                System.out.println("Please try again.");
            }

        }

        // TODO de scris fiecare achizite de bilet intr-un .txt  (?)

    }
}
