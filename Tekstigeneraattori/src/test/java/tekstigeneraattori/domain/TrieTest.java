package tekstigeneraattori.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {

    Trie puu;
    Solmu juuri;

    @Before
    public void setUp() {
        puu = new Trie();
    }

    @Test
    public void puunLuominenAlustaaJuurisolmun() {
        assertTrue(puu.juuri.solmut != null && puu.juuri.frekvenssi == 1);
    }

    @Test
    public void lisääMerkitLisääOikeanMäääränSolmujaTrieen() {
        puu.lisääMerkit("valo", 3);

        assertTrue(puu.juuri.solmut.containsKey("val"));
        assertTrue(puu.juuri.solmut.containsKey("alo"));
    }

    @Test
    public void lisääMerkitKasvattaaFrekvenssiäJosSolmuLöytyy() {
        puu.lisääMerkit("valo", 3);
        puu.lisääMerkit("valo", 3);

        assertTrue(puu.juuri.solmut.get("val").frekvenssi == 2);
        assertTrue(puu.juuri.solmut.get("alo").frekvenssi == 2);
    }

    @Test
    public void lisääMerkitLuoUudenLapsisolmun() {
        puu.lisääMerkit("valo", 3);
        puu.lisääMerkit("vala", 3);
        Solmu vanhempi = puu.juuri.solmut.get("val");

        assertTrue(vanhempi.solmut.containsKey("o"));
        assertTrue(vanhempi.solmut.containsKey("a"));
    }

    @Test
    public void luoSanaEiLuoLiianPitkääSanaa() {
        puu.lisääMerkit("valo", 2);
        puu.lisääMerkit("vala", 2);
        String sana = puu.luoSana(2, 4);
        assertTrue(sana.length() == 4);
    }

    @Test
    public void erotusMetodiPalauttaaItseisarvonNegatiivisellaArvoilla() {
        Double erotus = puu.erotus(0.54865, -0.876);
        assertTrue(1.42465 == erotus);
    }

}
