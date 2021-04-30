package tekstigeneraattori.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class HajautustauluTest {

    Hajautustaulu taulu;

    @Before
    public void setUp() {
        taulu = new Hajautustaulu();
    }

    @Test
    public void hajautusTauluAlustetaanOikein() {
        assertTrue(taulu.avaimet != null);
        assertTrue(taulu.solmut != null);
        assertTrue(taulu.koko() == 0);
    }

    @Test
    public void lisääMetodiLisääArvonJaSolmun() {
        Solmu uus = new Solmu();
        String avain = "valo";
        taulu.lisää(avain, uus);

        assertTrue(taulu.koko() == 1);
        assertTrue(taulu.solmut.contains(uus));
        assertTrue(taulu.containsKey(avain));
    }

    @Test
    public void getMetodiPalauttaaNullJosSolmuEiLöydy() {
        assertTrue(taulu.get("moimoi") == null);

    }

}
