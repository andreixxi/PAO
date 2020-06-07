package app.model;

public class Event {

    private int eventNo;
    private String venue, city, country, date;
    private int seatingCapacity;
    private Artist artist;
    private Organiser organiser;
    private Sponsor sponsor;

    public Event() {
    }

    public Event(int eventNo, String venue, String city, String country, String date, int seatingCapacity, Artist artist, Organiser organiser, Sponsor sponsor) {
        this.eventNo = eventNo;
        this.venue = venue;
        this.city = city;
        this.country = country;
        this.date = date;
        this.seatingCapacity = seatingCapacity;
        this.artist = artist;
        this.organiser = organiser;
        this.sponsor = sponsor;
    }

    public int getEventNo() {
        return eventNo;
    }

    public void setEventNo(int eventNo) {
        this.eventNo = eventNo;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setArtistName(String artistName) {
        this.artist.setName(artistName);
    }

    public Organiser getOrganiser() {
        return organiser;
    }

    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }


    @Override
    public String toString() {
        return "venue='" + venue + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", date='" + date + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", artist=" + artist +
                ", organiser=" + organiser +
                ", sponsor=" + sponsor;
    }
}
