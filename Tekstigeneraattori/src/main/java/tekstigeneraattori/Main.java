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
        puu.lisääMerkit("valo", 3);
        puu.lisääMerkit("valas", 3);
        puu.lisääMerkit("valaa", 3);
//        puu.lisääMerkit("ihana", 2);
//        puu.lisääMerkit("the theremin is theirs, ok? yes, it is. this is a theremin.", 3);
//        puu.laskeFrekvenssistäTodennäköisyys();
        System.out.println(puu.luoTekstiä("val", 2, 3));
        System.out.println("!");
    }
}
