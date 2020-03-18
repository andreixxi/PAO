import java.util.Objects;

public class CandyBox {
    private String flavour;
    private String origin;

    public CandyBox() {
        this.flavour = "";
        this.origin = "";
    }

    public CandyBox(String flavour, String origin) {
        this.flavour = flavour;
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return "The{" +
                "flavour='" + flavour + '\'' +
                ", origin='" + origin + '\'' +
                '}' + " has volume " + this.getVolume();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        CandyBox cb = (CandyBox) obj;
        //verifica doar flavour
        return this.flavour.equals(cb.flavour);
    }
}
