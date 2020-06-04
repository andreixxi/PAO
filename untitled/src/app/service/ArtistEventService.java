package app.service;

import app.model.Artist;
import app.model.Organiser;
import app.model.Sponsor;
import app.model.Ticket;

import java.util.List;

public interface ArtistEventService {

    void readArtists();

    void showArtists();

    void readEventInfo();

    void showEventInfo();

    Artist findArtist(String name);

    boolean doEvent(List<Sponsor> sponsorList, List<Ticket> ticketList, Organiser organiser);

}
