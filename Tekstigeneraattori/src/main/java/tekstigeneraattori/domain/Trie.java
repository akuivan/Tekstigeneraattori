package tekstigeneraattori.domain;

import java.util.Random;

/**
 * Trie luokka pitää sisällään trie-tietorakenteen merkkien tallentamista ja
 * käsittelyä varten.
 */
public class Trie {

    Solmu juuri;

    /**
     * Metodi luo trie -tietorakenteen juurisolmun.
     */
    public Trie() {
        juuri = new Solmu();
    }
}
