package tekstigeneraattori.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ListaTest {

    Lista lista;

    @Before
    public void setUp() {
        lista = new Lista();
    }

    @Test
    public void listanLuominenAlustaaListanOikein() {
        assertTrue(lista.arvot.length == 4);
        assertTrue(lista.koko() == 0);
    }

    @Test
    public void kokoPalauttaaOikeanKoon() {
        lista.lisaa("valo");
        lista.lisaa("vala");
        lista.lisaa("valoisa");

        assertTrue(lista.koko() == 3);
    }

    @Test
    public void lisaaArvoKasvattaaListanKokoaTarvittaessa() {
        lista.lisaa("valo");
        lista.lisaa("vala");
        lista.lisaa("valoisa");
        lista.lisaa("valas");
        lista.lisaa("vakaa");

        assertTrue(lista.arvot.length == 6);
    }

    @Test
    public void arvoMetodiPalauttaaArvonKohdastaIndeksi() {
        lista.lisaa("valo");
        lista.lisaa("vala");
        lista.lisaa("valoisa");
        lista.lisaa("valas");
        lista.lisaa("vakaa");

        assertTrue(lista.arvo(4).equals("vakaa"));
    }

    @Test
    public void containsPalauttaaTrueJosArvoLöytyy() {
        lista.lisaa("valo");

        assertTrue(lista.contains("valo"));
    }

    @Test
    public void containsPalauttaaFakseJosArvoEiLöydy() {
        lista.lisaa("valo");

        assertFalse(lista.contains("moi!"));
    }

    // Poikkeuksien testausta varten
    @Rule
    public final ExpectedException poikkeus = ExpectedException.none();

    @Test
    public void arvoMetodiEiPalautaArvoaJosIndeksiOnYli() {
        lista.lisaa("valo");
        lista.lisaa("vala");
        lista.lisaa("valoisa");
        lista.lisaa("valas");
        lista.lisaa("vakaa");

        poikkeus.expect(ArrayIndexOutOfBoundsException.class);
        lista.arvo(8);
    }

    @Test
    public void arvoMetodiEiPalautaArvoaJosIndeksiOnNegatiivinen() {
        lista.lisaa("valo");
        lista.lisaa("vala");
        lista.lisaa("valoisa");
        lista.lisaa("valas");
        lista.lisaa("vakaa");

        poikkeus.expect(ArrayIndexOutOfBoundsException.class);
        lista.arvo(-8);
    }

}
