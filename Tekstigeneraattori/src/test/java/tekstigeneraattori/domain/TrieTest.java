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
}
