package tekstigeneraattori;

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
        Trie puu = new Trie();
        puu.lisääMerkit("valovalo", 3);
//        puu.laskeFrekvenssistäTodennäköisyys();
    }
}
