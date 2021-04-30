package tekstigeneraattori.domain;

/**
 * Luokka vastaa ArrayList -tietorakennetta.
 */
public class Lista<T> {

    public T[] arvot;
    private int koko;

    /**
     * Metodi luo ja alustaa Lista -olion, johon voidaan tallentaa arvoja.
     */
    public Lista() {
        this.arvot = (T[]) new Object[4];
        this.koko = 0;
    }

    /**
     * Metodi lisää arvon listaan.
     *
     * @param arvo on listaan tallennettava arvo.
     */
    public void lisaa(T arvo) {
        if (this.koko == this.arvot.length) {
            kasvata();
        }

        this.arvot[this.koko] = arvo;
        this.koko++;
    }

    /**
     * Metodi kasvattaa listan kokoa tarvittaessa.
     *
     */
    private void kasvata() {
        int uusiKoko = this.arvot.length + this.arvot.length / 2;
        T[] uusi = (T[]) new Object[uusiKoko];
        for (int i = 0; i < this.arvot.length; i++) {
            uusi[i] = this.arvot[i];
        }

        this.arvot = uusi;
    }

    /**
     * Metodi tarkistaa, löytyykö arvoa listasta tietystä kohdasta.
     *
     * @param indeksi on kohta, josta tarkistetaan löytyykö arvoa.
     *
     * @return löytynyt arvo.
     */
    public T getArvo(int indeksi) {
        if (indeksi < 0 || indeksi >= this.koko) {
            throw new ArrayIndexOutOfBoundsException("Indeksi " + indeksi + " alueen [0, " + this.koko + "[ ulkopuolella.");
        }

        return this.arvot[indeksi];
    }

    /**
     * Metodi kertoo listan sen hetkisen koon.
     *
     * @return listan koko int -muodossa.
     */
    public int koko() {
        return this.koko;
    }

    /**
     * Metodi kertoo, löytyykö tiettyä arvoa listasta ollenkaan.
     *
     * @param arvo on se, mitä listasta haetaan.
     *
     * @return Boolean true, jos arvo löytyy listasta. Muutoin false.
     */
    public Boolean contains(T arvo) {
        Boolean löytyy = false;

        for (int i = 0; i < this.arvot.length; i++) {
            if (arvo.equals(this.arvot[i])) {
                löytyy = true;
                break;
            }
        }
        return löytyy;
    }

    /**
     * Metodi palauttaa indeksin, josta tietty arvo löytyy.
     *
     * @param arvo on se, mitä listasta haetaan.
     *
     * @return jos arvo löytyy, metodi palauttaa indeksin. Muutoin -1.
     */
    public int indeksi(T arvo) {
        for (int i = 0; i < this.arvot.length; i++) {
            if (arvo.equals(this.arvot[i])) {
                return i;
            }
        }
        return -1;
    }

}
