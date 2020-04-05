package app;

public abstract class Ticket {

    private String date, startHour;
    private float price;
    private int seat;
    private Client client;
    private Artist artist;

    public Ticket() {
    }

    public Ticket(String date, String startHour, float price, int seat, Client client, Artist artist) {
        this.date = date;
        this.startHour = startHour;
        this.price = price;
        this.seat = seat;
        this.client = client;
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "date='" + date + '\'' +
                ", startHour='" + startHour + '\'' +
                ", price=" + price +
                ", seat=" + seat +
                ", client=" + client +
                ", artist=" + artist;
    }

    public abstract float priceCalc(float price);

}
