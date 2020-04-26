package app.service;

import app.model.Artist;
import app.model.StandardTicket;
import app.model.Ticket;
import app.model.VipTicket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TicketServiceImpl implements TicketService {

    private float[] ticketPrices;
    private List<Ticket> tickets; //tickets sold

    public TicketServiceImpl() {
        this.ticketPrices = new float[2];
    }

    public float[] getTicketPrices() {
        return ticketPrices;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
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

    @Override
    public void showTicketPrices() {
        System.out.println("The standard ticket is: " + ticketPrices[0] + " and the vip ticket is: " + ticketPrices[1]);
    }

    @Override
    public void priceCalc(Artist artist) {
        Ticket ticket = new StandardTicket(null, null, ticketPrices[0], 0, null, artist);
        float newPrice = ticket.priceCalc(ticketPrices[0]);
        ticketPrices[0] = newPrice; //standard ticket

        ticket = new VipTicket(null, null, ticketPrices[0], 0, null, artist);
        newPrice = ticket.priceCalc(ticketPrices[1]);
        ticketPrices[1] = newPrice; //vip ticket
    }

}
