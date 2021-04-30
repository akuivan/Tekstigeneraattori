package tekstigeneraattori;

// MUISTA SIIVOTA NÄMÄKIN
import tekstigeneraattori.domain.Hajautustaulu;
import tekstigeneraattori.domain.Lista;
import tekstigeneraattori.domain.Trie;
import tekstigeneraattori.domain.Solmu;
import tekstigeneraattori.ui.TekstigeneraattoriUi;

/**
 * Sovelluksen käynnistys.
 */
public class Main {

    /**
     * Metodi käynnistää sovelluksen. Myöhemmin tulee käynnistämään graafisen
     * käyttöliittymän.
     *
     * @param args on Main luokan antama muuttuja.
     */
    public static void main(String[] args) {
        TekstigeneraattoriUi.main(args); //käyn graaf.liittymä

// omaa "testausta" ja muistiinpanoja (tulee postumaan myöh.):
// trien rakenne jos koostuu sanasta "valo" ja k=3:    
//    juuri --> val ---> o
//     |
//      --> alo ---> null
//        Trie puu = new Trie();
//        puu.lisääMerkit("valo", 3);
//        puu.lisääMerkit("valo", 4);
//        puu.lisääMerkit("joku", 2);
//        puu.lisääMerkit("joku", 3);
//        puu.lisääMerkit("joku", 4);
//        puu.lisääMerkit("valoisa", 2);
//        puu.lisääMerkit("valoisa", 3);
//        puu.lisääMerkit("valoisa", 4);
//        puu.lisääMerkit("valaa", 2);
//        puu.lisääMerkit("valaa", 3);
//        puu.lisääMerkit("valaa", 4);
//
//        System.out.println(puu.luoSana(2, 6));
//
// Projektista puuttuu: 
// -refaktorointi (tiedoston lukeminen omaan luokkaan ja ylimäär. kommenttien
// poisto YM.)
//  - testien päivitys
//  -suorituskykytestaus
// - dokumentointi
    }
}
