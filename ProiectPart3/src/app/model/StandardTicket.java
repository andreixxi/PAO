package app.model;

public class StandardTicket extends Ticket {

    public StandardTicket() {
    }

    public StandardTicket(String date, String startHour, float price, int seat, Client client, Artist artist) {
        super(date, startHour, price, seat, client, artist);
    }

    @Override
    public float priceCalc(float price) {
        float fee = 0.08f * price;
        int dancers = (this.getArtist().isDancers()) ? 7 : 0;
        int guests = (this.getArtist().isGuests()) ? 10 : 0;
        return price + fee + dancers + guests;
    }
}
