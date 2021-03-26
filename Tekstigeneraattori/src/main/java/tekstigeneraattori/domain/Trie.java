package tekstigeneraattori.domain;

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

    /**
     * Metodi lisää trie -tietorakenteeseen käsiteltävän datan perusteella
     * merkkejä/merkkkiyhdistelmiä ja tiedon niitä seuraavista kirjaimista.
     * Mikäli merkki/merkkihdistelmä, eli sen solmu, löytyy jo, kasvatetaan sen
     * frekvenssiä yhdellä.
     *
     * @param data on String -muodossa sovellukselle annettu opetusdata.
     *
     * @param k on arvo, joka kertoo markovin ketjun asteen ts. kuinka monta
     * kirjainta tarkastellaan kerrallaan annetusta datasta. Jos esim. k = 2,
     * silloin tarkastellaan aina kahta kirjainta kerrallaan ja katsotaan, mikä
     * kirjain seuraa näiden kahden kirjaimen jälkeen.
     */
    public void lisääMerkit(String data, int k) {
        for (int i = 0; i <= data.length() - k; i++) {
            String merkit = data.substring(i, i + k);

            if (!juuri.solmut.containsKey(merkit)) {
                if (i + k >= data.length()) {
                    juuri.solmut.put(merkit, new Solmu());
                    break;
                } else {
                    String seuraavaKirjain = String.valueOf(data.charAt(i + k));
                    Solmu uusi = new Solmu();
                    uusi.solmut.put(seuraavaKirjain, new Solmu());
                    juuri.solmut.put(merkit, uusi);
                }
            } else {
                juuri.solmut.get(merkit).kasvataFrekvenssiä();
            }
        }
    }

    /**
     * Metodi hakee merkit trie -tietorakenteesta. Tämä metodi on vielä kesken
     * ja tulee mahd. muuttumaan tarvitumman kaltaiseksi sitten kun projektissa
     * päästään siihen vaiheeseen, että aletaan laskemaan todennäköisyyksiä ja
     * generoimaan varsinaisia uusia luonnollisen kaltaisia sanoja.
     *
     * @param haettava on String -muotoinen avainarvo.
     *
     * @return solmu jos löytyy, muutoin null.
     */
    public String haeMerkit(String haettava) {
        for (String solmu : juuri.solmut.keySet()) {
            if (solmu.equals(haettava)) {
                return solmu;
            }
        }
        return null;
    }

}
