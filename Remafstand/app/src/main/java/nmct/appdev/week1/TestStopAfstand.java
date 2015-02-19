package nmct.appdev.week1;

public class TestStopAfstand {

    public static void main(String[] args) {
        System.out.println("Demo oefening 1");

        Voertuig voertuig = new Voertuig(Voertuig.Merk.AIXAM, 2014);
        System.out.println(voertuig);

        StopAfstandInfo info = new StopAfstandInfo(89, 1.4, StopAfstandInfo.Wegtype.WEGDEK_NAT);
        System.out.println("De stopafstand is " + info.getStopAfstand());

    }
}
