package tekstigeneraattori.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import tekstigeneraattori.domain.Markov;

/**
 * Tämän luokan avulla luetaan txt.tiedostoja.
 */
public class TiedostonLukija {

    Markov markov;

    /**
     * Metodi alustaa lukijan, jonka avulla käydään läpi annettua txt.tiedostoa.
     *
     * @param markov on Markovin ketju, joka pitää sisällään trie-
     * tietorakenteen, johon halutaan lukijan tallentavan dataa luettavasta
     * tiedostosta, ja se asetetaan lukijan oiomuuttujaksi.
     *
     */
    public TiedostonLukija(Markov markov) {
        this.markov = markov;
    }

    /**
     * Metodi lukee käyttäjän avamaan tekstitiedoston.
     *
     * @param valittu on valittu txt.tiedosto.
     *
     */
    public void lueTiedosto(File valittu) {
        try (BufferedReader lukija = new BufferedReader(new FileReader(valittu))) {
            String rivi;

            while ((rivi = lukija.readLine()) != null) {
                //tallenna 2,3 ja 4 -asteen markovit trie -tietorakenteesen
                tallennaMarkovit(rivi);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodi tallentaa rivi ja sana kerrallaan merkkejä ja merkkiyhdistelmiä
     * trieen Markovin asteilla 2, 3 ja 4.
     *
     * @param rivi on luettu txt.tiedoston rivi.
     */
    private void tallennaMarkovit(String rivi) {
        //jätä huomiotta välilyönnit ym. merkit ja muuta isot kirjaimet pieniksi
        String[] rivit = rivi.toLowerCase().split("\\W+");
        int indeksi = 0;

        while (indeksi < rivit.length) {
            String sana = rivit[indeksi];
            // ja jos sana onkin rivinvaihto, numeerinen tai sisältää numeron
            if (sana.isEmpty() || onNumero(sana) || sisältääNumeron(sana)) {
                indeksi++;
                continue; // sitä ei tallenneta.
            }
            // muutoin lisää ko. sana trie -rakenteeesen
            markov.lisääMerkit(sana, 2);
            markov.lisääMerkit(sana, 3);
            markov.lisääMerkit(sana, 4);
            indeksi++;
        }
    }

    /**
     * Metodi tarkistaa onko sana sittenkin numero.
     *
     * @param sana on tarkistettava sana.
     *
     * @return jos sana on numero, palautuu true. Muutoin false.
     */
    private static boolean onNumero(String sana) {
        return sana.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Metodi tarkistaa onko osassa sanasta numeroja.
     *
     * @param sana on tarkistettava sana.
     *
     * @return jos sana sisältää numeron/numeroita, palautuu true. Muutoin
     * false.
     */
    private static boolean sisältääNumeron(String sana) {
        return sana.matches(".*\\d.*");
    }

}
