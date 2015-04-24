package nmct.appdev.week02.oefening2;

public class BmiInfo {
    public static enum Category {
        GrootOndergewicht(0, 15), ErnstigOndergewicht(15, 16), Ondergewicht(16, 18.5), Normaal(18.5, 25), Overgewicht(25, 30), MatigOvergewicht(30, 35), ErnstigOvergewicht(35, 40), ZeerGrootOvergewicht(40, 100);

        private double onderGrens;
        private double bovenGrens;

        private Category(double onderGrens, double bovenGrens) {
            this.onderGrens = onderGrens;
            this.bovenGrens = bovenGrens;
        }

        public double getOnderGrens() {
            return onderGrens;
        }

        public double getBovenGrens() {
            return bovenGrens;
        }

        public boolean isInBoundary(double test) {
            return test > getOnderGrens() && test <= getBovenGrens();
        }

        public static Category getCategory(double index) {
            for (Category category : Category.values()) {
                if (category.isInBoundary(index)) return category;
            }

            return null;
        }
    }

    private double height = 1.70;
    private int mass = 70;

    public BmiInfo() {
        // default constructor
    }

    public BmiInfo(double height, int mass) {
        this.height = height;
        this.mass = mass;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public Category getCategory() {
        return Category.getCategory(getIndex());
    }

    public double getIndex() {
        return getMass() / Math.pow(getHeight(), 2);
    }
}
