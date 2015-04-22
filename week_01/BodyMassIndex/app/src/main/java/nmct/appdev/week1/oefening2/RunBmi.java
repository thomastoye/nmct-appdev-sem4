package nmct.appdev.week1.oefening2;

public class RunBmi {

    public static void main(String[] args) {

        BmiInfo info = new BmiInfo(1.94, 85);

        System.out.println(info.getIndex());
        System.out.println(info.getCategory());
    }
}
