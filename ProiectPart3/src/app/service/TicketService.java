package app.service;

import app.model.Artist;

public interface TicketService {

    void readTicketPrices();

    void showTicketPrices();

    void priceCalc(Artist artist);
}
