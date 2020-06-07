package app.model;

import java.util.Arrays;

public class Artist extends Person {

    private boolean dancers, guests, groupPic;
    private String[] bookedDates;

    public Artist() {
    }

    public boolean isGroupPic() {
        return groupPic;
    }

    public void setGroupPic(boolean groupPic) {
        this.groupPic = groupPic;
    }

    public Artist(String name, boolean dancers, boolean guests, String[] bookedDates, boolean groupPic) {
        super(name);
        this.dancers = dancers;
        this.guests = guests;
        this.bookedDates = bookedDates;
        this.groupPic = groupPic;
    }


    public boolean isDancers() {
        return dancers;
    }

    public void setDancers(boolean dancers) {
        this.dancers = dancers;
    }

    public boolean isGuests() {
        return guests;
    }

    public void setGuests(boolean guests) {
        this.guests = guests;
    }

    public String[] getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(String[] bookedDates) {
        this.bookedDates = bookedDates;
    }

    @Override
    public String toString() {
        return super.toString() + "dancers=" + dancers +
                ", guests=" + guests +
                ", groupPic=" + groupPic +
                ", bookedDates=" + Arrays.toString(bookedDates);
    }
}
