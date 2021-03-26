package tekstigeneraattori.domain;

import java.util.HashMap;

public class Solmu {

    HashMap<String, Solmu> solmut; //voisi tallentaa eriasteen markoveja?
    Integer frekvenssi;

    public Solmu() {
        solmut = new HashMap<>();
        frekvenssi = 1;
    }

    public void kasvataFrekvenssiä() {
        frekvenssi++;
    }
}
