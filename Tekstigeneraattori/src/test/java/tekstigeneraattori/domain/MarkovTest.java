package tekstigeneraattori.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MarkovTest {

    Markov markov;

    @Before
    public void setUp() {
        markov = new Markov();
    }

    @Test
    public void lisääMerkitLisääOikeanMäääränSolmujaTrieen() {
        markov.lisääMerkit("valo", 3);

        assertTrue(markov.trie.juuri.solmut.containsKey("val"));
        assertTrue(markov.trie.juuri.solmut.containsKey("alo"));
    }

    @Test
    public void lisääMerkitKasvattaaFrekvenssiäJosSolmuLöytyy() {
        markov.lisääMerkit("valo", 3);
        markov.lisääMerkit("valo", 3);

        assertTrue(markov.trie.juuri.solmut.get("val").frekvenssi == 2);
        assertTrue(markov.trie.juuri.solmut.get("alo").frekvenssi == 2);
    }

    @Test
    public void lisääMerkitLuoUudenLapsisolmun() {
        markov.lisääMerkit("valo", 3);
        markov.lisääMerkit("vala", 3);
        Solmu vanhempi = markov.trie.juuri.solmut.get("val");

        assertTrue(vanhempi.solmut.containsKey("o"));
        assertTrue(vanhempi.solmut.containsKey("a"));
    }

    @Test
    public void luoSanaEiLuoLiianPitkääSanaa() {
        markov.lisääMerkit("valo", 2);
        markov.lisääMerkit("vala", 2);
        String sana = markov.luoSana(2, 4);
        assertTrue(sana.length() == 4);
    }

    @Test
    public void erotusMetodiPalauttaaItseisarvonNegatiivisellaArvoilla() {
        Double erotus = markov.erotus(0.54865, -0.876);
        assertTrue(1.42465 == erotus);
    }

}
