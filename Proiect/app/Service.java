package app;

import java.util.List;

public interface Service {

    void addTicket(Ticket ticket);

    boolean doEvent(List<Sponsor> sponsorList, List<Ticket> ticketList, Organiser organiser);

    Artist findArtist(String name);

    void priceCalc(Artist artist);

    //TODO adaugat altele?

    void readArtists();

    void showArtists();

    void readOrganisers();

    void showOrganisers();

    void readEventInfo();

    void showEventInfo();

    void readSponsors();

    void showSponsors();

    void readTicketPrices();

    void showTicketPrices();

}
