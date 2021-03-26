package tekstigeneraattori.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SolmuTest {

    Solmu solmu;

    @Before
    public void setUp() {
        solmu = new Solmu();
    }

    @Test
    public void solmunLuominenAlustaaHashMapinOikein() {
        assertTrue(solmu.solmut.isEmpty());
    }

    @Test
    public void solmunLuominenAlustaaFrekvenssinOikein() {
        assertTrue(1 == solmu.frekvenssi);
    }

    @Test
    public void kasvataFrekvenssiäKasvattaaFrekvenssiäYhdellä() {
        solmu.kasvataFrekvenssiä();
        solmu.kasvataFrekvenssiä();
        assertTrue(3 == solmu.frekvenssi);
    }

}
