package app.model;

public class VipTicket extends Ticket {


    public VipTicket() {
    }

    public VipTicket(String date, String startHour, float price, int seat, Client client, Artist artist) {
        super(date, startHour, price, seat, client, artist);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public float priceCalc(float price) {
        float fee = 0.13f * price;
        int dancers = (this.getArtist().isDancers()) ? 9 : 0;
        int guests = (this.getArtist().isGuests()) ? 12 : 0;
        int groupPic = (this.getArtist().isGroupPic()) ? 5 : 0;
        return price + fee + dancers + guests + groupPic;
    }
}
