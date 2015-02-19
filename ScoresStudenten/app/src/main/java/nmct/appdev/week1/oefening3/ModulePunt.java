package nmct.appdev.week1.oefening3;

public class ModulePunt {
    private String moduleNaam;
    private int aantalStudiePunten;
    private double score;

    public ModulePunt(String moduleNaam, int aantalStudiePunten, double score) {
        this.moduleNaam = moduleNaam;
        this.aantalStudiePunten = aantalStudiePunten;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModulePunt that = (ModulePunt) o;

        if (aantalStudiePunten != that.aantalStudiePunten) return false;
        if (Double.compare(that.score, score) != 0) return false;
        if (moduleNaam != null ? !moduleNaam.equals(that.moduleNaam) : that.moduleNaam != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = moduleNaam != null ? moduleNaam.hashCode() : 0;
        result = 31 * result + aantalStudiePunten;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getModuleNaam() {
        return moduleNaam;
    }

    public void setModuleNaam(String moduleNaam) {
        this.moduleNaam = moduleNaam;
    }

    public int getAantalStudiePunten() {
        return aantalStudiePunten;
    }

    public void setAantalStudiePunten(int aantalStudiePunten) {
        this.aantalStudiePunten = aantalStudiePunten;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
