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
        assertTrue(puu.juuri.solmut.isEmpty() && puu.juuri.frekvenssi == 1);
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
    
    // Search -metodille ei vielä testiä, sillä kyseinen metodi tulee vielä
    // mahd. muuttumaan eikä ole vielä käytössä

}
