package app;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //TODO de pus date normale in .txt

        Test test = new Test();
        test.readTicketPrices();
        test.readArtists();
        System.out.println("Before sorting the artists' names:");
        test.showArtists();

        Collections.sort(test.getArtistList(), new Sort());
        System.out.println("After sorting the artists' names:");
        test.showArtists();

        test.readOrganisers();
//        test.showOrganisers();

        test.readSponsors();
//        test.showSponsors();

        test.readEventInfo();
        test.showEventInfo();
        Person client = new Client("Client", "surname", "forename", "email@domain.com", 25);
        System.out.println(client);

        Scanner scanner = new Scanner(System.in);
        int eventNo = -1;
        boolean rasp_valid = false;
        while (!rasp_valid) {
            test.showEventInfo();
            System.out.println("Choose the event you want to attend. Type its number.");
            eventNo = scanner.nextInt();
            if (eventNo > 0 && eventNo <= test.getEventList().size()) {
                rasp_valid = true;
            } else {
                System.out.println("Please try again.");
            }
        }

        rasp_valid = false;
        int seat = 0;
        Artist artist = test.getEventList().get(eventNo - 1).getArtist(); //the artist the user chose to go to
        test.priceCalc(artist); //add the extra fees
        String ticketType = "";

        while (!rasp_valid) {
            System.out.println("Choose the type of ticket you want to purchase. Press s for standard ticket, v for vip ticket.");
            System.out.println("The tickets prices are: ");
            test.showTicketPrices();
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
                price = test.getTicketPrices()[0];
                ticketName = "Standard ticket";
            } else {
                price = test.getTicketPrices()[1];;  //for a vip ticket
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