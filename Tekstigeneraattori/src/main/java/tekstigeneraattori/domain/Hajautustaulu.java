package tekstigeneraattori.domain;

/**
 * Luokka on projektiin kustomoitu HashMapin virkaa toimittava luokka.
 */
public class Hajautustaulu<String, Solmu> {

    Lista<Solmu> solmut;
    Lista<String> avaimet;
    private int koko;

    /**
     * Metodi luo ja alustaa Lista -oliot, avaimille ja arvoille, eli solmuille,
     * omat. Lisäksi hajautustaulun kooksi alustetaan 0.
     */
    public Hajautustaulu() {
        solmut = new Lista<>();
        avaimet = new Lista<>();
        koko = 0;
    }

    /**
     * Metodi lisää arvon ja avaimen hajautustauluun, niiden omille listoille.
     *
     * @param solmu on listaan tallennettava arvo.
     *
     * @param avain on listaan tallennettava avain, joka tässä vastaa
     * merkkiyhdistelmää.
     */
    public void lisää(String avain, Solmu solmu) {
        avaimet.lisaa(avain);
        solmut.lisaa(solmu);
        koko++;
    }

    /**
     * Metodi tarkistaa, löytyykö avainta hajautustaulusta (sen listasta).
     *
     * @param avain on listasta tarkistettava avain.
     *
     * @return Boolean true, jos avain löytyi. Muutoin false.
     */
    public Boolean containsKey(String avain) {
        return avaimet.contains(avain);
    }

    /**
     * Metodi hakee ja palauttaa arvon avaimen perusteella hajautustaulusta.
     *
     * @param avain on muuttuja, jonka perusteella haetaan avainta vastaava
     * arvo.
     *
     * @return Solmu, eli arvo, joka vastasi avainta.
     */
    public Solmu get(String avain) {
        int indeksi = avaimet.indeksi(avain);

        if (indeksi < 0) {
            return null;
        }

        return solmut.getArvo(indeksi);
    }

    /**
     * Metodi palauttaa hajautustaulun koon.
     *
     * @return int -tyyppinen muuttuja, joka kertoon hajautustaulun koon.
     */
    public int koko() {
        return koko;
    }
}
