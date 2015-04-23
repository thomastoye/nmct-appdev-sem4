package nmct.appdev.week02.stopafstand;

public class StopAfstandInfo {
    public static enum Wegtype {
        WEGDEK_DROOG(8),WEGDEK_NAT(5);

        private double value;

        private Wegtype(double value) {
            this.value = value;
        }

        private double getRemVertraging() {
            return value;
        }
    }

    private double snelheid; // in m/s
    private double reactieTijd;
    private Wegtype wegtype;

    public StopAfstandInfo(int snelheidInKmH, double reactieTijd, Wegtype wegtype) {
        this.snelheid = snelheidInKmH / 3.6;
        this.reactieTijd = reactieTijd;
        this.wegtype = wegtype;
    }

    public Wegtype getWegtype() {
        return wegtype;
    }

    public void setWegtype(Wegtype wegtype) {
        this.wegtype = wegtype;
    }

    public double getStopAfstand() {
        return getSnelheid() * getReactieTijd() + Math.pow(getSnelheid(), 2) / (2 * getWegtype().getRemVertraging());
    }

    public double getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(double snelheid) {
        this.snelheid = snelheid;
    }

    public double getReactieTijd() {
        return reactieTijd;
    }

    public void setReactieTijd(double reactieTijd) {
        this.reactieTijd = reactieTijd;
    }

}
