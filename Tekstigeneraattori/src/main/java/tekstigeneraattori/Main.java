package tekstigeneraattori;

import tekstigeneraattori.domain.Trie;
import tekstigeneraattori.domain.Solmu;
import tekstigeneraattori.ui.TekstigeneraattoriUi;

/**
 * Ohjelman käynnistys
 *
 */
public class Main {

    public static void main(String[] args) {
        Trie puu = new Trie();
        puu.lisääMerkit("valo", 3);
    }
}
