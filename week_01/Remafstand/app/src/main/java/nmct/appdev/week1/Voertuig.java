package nmct.appdev.week1;

public class Voertuig {
    public static enum Merk {
        OPEL, VOLKSWAGEN, TESLA, AIXAM
    }

    private Merk merk;
    private int bouwjaar;

    public Voertuig(Merk merk, int bouwjaar) {
        this.merk = merk;
        this.bouwjaar = bouwjaar;
    }

    @Override
    public String toString() {
        return "Voertuig{" +
                "merk='" + merk + '\'' +
                ", bouwjaar=" + bouwjaar +
                '}';
    }

    public Merk getMerk() {
        return merk;
    }

    public void setMerk(Merk merk) {
        this.merk = merk;
    }

    public int getBouwjaar() {
        return bouwjaar;
    }

    public void setBouwjaar(int bouwjaar) {
        this.bouwjaar = bouwjaar;
    }
}
