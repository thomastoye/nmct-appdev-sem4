package nmct.appdev.week1.oefening3;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String email;
    private Map scores = new HashMap<String, ModulePunt>();

    public void voegScoreToe(String moduleNaam, int aantalStudiePunten, double score) {
        scores.put(moduleNaam, new ModulePunt(moduleNaam, aantalStudiePunten, score));
    }

    public

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
