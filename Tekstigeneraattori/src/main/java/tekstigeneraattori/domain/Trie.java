package tekstigeneraattori.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Trie luokka pitää sisällään trie-tietorakenteen merkkien tallentamista ja
 * käsittelyä varten.
 */
public class Trie {

    Solmu juuri;
//    ArrayList<String> aloittavatMerkit;
    Lista<String> aloittavatMerkit;

    /**
     * Metodi luo trie -tietorakenteen juurisolmun.
     */
    public Trie() {
//        aloittavatMerkit = new ArrayList<>();
        aloittavatMerkit = new Lista<>();
        juuri = new Solmu();
    }

    /**
     * Metodi lisää trie -tietorakenteeseen käsiteltävän datan perusteella
     * merkkejä/merkkkiyhdistelmiä ja tiedon niitä seuraavista kirjaimista.
     * Mikäli merkki/merkkihdistelmä, eli sen solmu, löytyy jo, kasvatetaan sen
     * frekvenssiä yhdellä.
     *
     * @param sana on String -muodossa sovellukselle annettu opetusdata.
     *
     * @param k on arvo, joka kertoo markovin ketjun asteen ts. kuinka monta
     * kirjainta tarkastellaan kerrallaan annetusta datasta. Jos esim. k = 2,
     * silloin tarkastellaan aina kahta kirjainta kerrallaan ja katsotaan, mikä
     * kirjain seuraa näiden kahden kirjaimen jälkeen.
     */
    public void lisääMerkit(String sana, int k) {
        // jos sanan pituus on suurempi kuin valittu Markovin aste, niin 
        // lisää ko. sanan _aloittavat_ merkit (Markovin asteen mukaan) 
        // apulistaan, jota hyödynnetään myöhemmin sanojen generoimisessa.
        if (sana.length() > k) {
            lisääAloittavaMerkkiyhdistelmäListaan(sana.substring(0, k));
        }

        // lisätään trieen kaikki merkkiyhdistelmät
        for (int i = 0; i <= sana.length() - k; i++) {
            String merkit = sana.substring(i, i + k); //lisättävä merkkiyhdistelmä

            // jos merkkiyhdistelmä on täysin uusi
            if (!juuri.solmut.containsKey(merkit)) {
                if (i + k >= sana.length()) {
                    // jos sanan merkit loppuivat kesken, lisää viimeiset merkit,
                    // eli solmu, trieen
                    juuri.solmut.put(merkit, new Solmu());
                    break;
                } else {
                    //lisää uusi solmu ja sen lapsisolmu, eli 
                    //merkkiyhdistelmälle sitä seuraava merkki
                    String seuraavaKirjain = String.valueOf(sana.charAt(i + k));
                    Solmu uusi = new Solmu();
                    uusi.solmut.put(seuraavaKirjain, new Solmu());
                    juuri.solmut.put(merkit, uusi);
                }
            } else {
                // jos merkkiyhdistelmä, eli solmu, löytyy jo ennestään niin 
                // hae ko. solmu ja kasvata sen frekvenssiä
                Solmu nykyinen = juuri.solmut.get(merkit);
                nykyinen.kasvataFrekvenssiä();
                if (i + k >= sana.length()) { // sanan käsittely päättyy
                    break;
                }
                // katsotaan, mikä on merkki seuraa merkkiyhdistelmää
                String seuraavaKirjain = String.valueOf(sana.charAt(i + k));

                //lisää/päivitä ko. solmun lapsisolmu(ja)
                if (nykyinen.solmut.containsKey(seuraavaKirjain)) {
                    // jos lapsisolmu, eli seuraava merkki löytyy jo,
                    // niin kasvatetaan sen frekvenssiä
                    nykyinen.solmut.get(seuraavaKirjain).kasvataFrekvenssiä();
                } else {
                    //lisää uusi lapsisolmu
                    nykyinen.solmut.put(seuraavaKirjain, new Solmu());
                }
            }
        }
    }

    /**
     * Metodi generoi sanan opetusdatan perusteella.
     *
     *
     * @param k on arvo, joka kertoo markovin ketjun asteen ts. kuinka monta
     * kirjainta tarkastellaan kerrallaan annetusta datasta. Jos esim. k = 2,
     * silloin tarkastellaan aina kahta kirjainta kerrallaan ja katsotaan, mikä
     * kirjain seuraa näiden kahden kirjaimen jälkeen.
     *
     * @param pituus on arvo, joka kertoo, kuinka monta pitkä generoitava sanan
     * halutaan olevan.
     *
     * @return generoitu sana.
     */
    public String luoSana(int k, int pituus) {
        // laske/päivitä todennäköisyydet
        laskeFrekvenssistäTodennäköisyys();
        // hae sanan aloittavat merkit
        String välisana = arvoAloittavaMerkkiyhdistelmä(k);
        String uusi = ""; // Oma muistiinpano: vai stringbuilder?
        uusi += välisana;

        // käydään trie -tietorakennetta läpi
        for (int i = 0; i < juuri.solmut.size(); i++) {
            // jos merkkiyhdistelmä löytyy
            if (juuri.solmut.containsKey(välisana)) {
                Solmu tarkasteltavaSolmu = juuri.solmut.get(välisana);

                String seur = seuraavaMerkki(tarkasteltavaSolmu);
                välisana += seur;
                välisana = välisana.substring(välisana.length() - k,
                        välisana.length());

                // lopetus jos jatkoa ei merkkiyhdistelmälle löydy ja varmistus,
                // ettei sanasta tule käyttäjän toiveisiin nähden liian pitkää
                String tarkista = uusi + seur;
                if (tarkista.length() > pituus || seur.isEmpty()) {
                    break;
                }
                uusi += seur;
            }
        }
        return uusi;
    }

    /**
     * Tämä (apu)metodi lisää listaan sellaisia merkkiyhdistelmiä, jotka ovat
     * opetusdatassa aloittaneet sanan. Tätä listaa käytetään siis apuna uusien
     * sanojen generoimisessa.
     *
     * @param merkit on sanan aloittanut merkkiyhdistelmä.
     *
     */
    public void lisääAloittavaMerkkiyhdistelmäListaan(String merkit) {
        if (aloittavatMerkit.contains(merkit)) {
            return;
        } else {
            aloittavatMerkit.lisaa(merkit);
        }
    }

    /**
     * Tämä (apu)metodi arpoo, millä merkkiyhdistelmällä uusi generoitu sana
     * tulee alkamaan (perustuen opetusdataan).
     *
     * @param k on Markovin ketjun aste.
     *
     * @return merkkiyhdistelmä, joka on opetusdatassa aloittanut sanan.
     */
    public String arvoAloittavaMerkkiyhdistelmä(int k) {
        String avain = "";
        while (avain.length() != k) {
            Object[] avaimet = aloittavatMerkit.arvot;
//            Object[] avaimet = aloittavatMerkit.toArray(); alkup.

            Object väliavain = null; //alustus
            // listan koon kasvatus ominaisuuden vuoksi väliavaimeksi
            // voi osua null -arvo, minkä vuoksi tällainen while -ehto.
            while (väliavain == null) {
                väliavain = avaimet[new Random().nextInt(avaimet.length)];
            }
//            Object väliavain = avaimet[new Random().nextInt(avaimet.length)]; alkup.
            avain = (String) väliavain;
        }
        return avain;
    }

    /**
     * Metodi arpoo seuraavan merkin opetusdatasta saatujen frekvenssien
     * perusteella ja palauttaa sen. HIEMAN KESKEN.
     *
     * @param solmu on Trie -rakenteen solmu, jota sillä hetkellä tarkastellaan
     * ja jota seuraavaa merkkiä määritellään.
     *
     * @return merkkiyhdistelmää seuraava merkki/kirjain.
     */
    public String seuraavaMerkki(Solmu solmu) {
        double random = Math.random(); // satunnaisluku väliltä 0-1
        // tai
//        double random = new Random().nextDouble();
//        System.out.println(random);
        String kirjain = "";
        double lähin = 1.0;
        Solmu lähinSolmu;

        for (HashMap.Entry<String, Solmu> en : solmu.solmut.entrySet()) {
            Solmu lapsi = en.getValue();
            double erotus = erotus(random, lapsi.todennäköisyys);

            if (erotus == lähin) { // jos 50:50 todnäk.
                erotus = Math.random(); //niin arvo randomilla
            }

            // seur kirjaimeksi valitaan se, jonka todennäköisyyttä
            // kuvaava arvo osuu lähemmäksi satunnaislukua
            if (erotus < lähin) {
                lähin = erotus;
                lähinSolmu = lapsi;
                kirjain = en.getKey();
            }
        }
        return kirjain;
    }

    /**
     * Tämä (apu)metodi laskee, kuinka lähellä lapsisolmun todennäköisyys on
     * satunnaislukua väliltä 0-1. Se siis määrittää, kuinka lähellä/kaukana
     * tämän todennäköisyys on satunnaislukua.
     *
     * @param random on satunnaisluku.
     *
     * @param lapsiSolmunTodennäköisyys on frekvensseistä ko. solmulle laskettu
     * arvo, joka kertoo kuinka suurella todennäköisyydellä merkki seuraa jotain
     * tiettyä merkkiä/merkkiyhdistelmää.
     *
     * @return satunnaisluvun ja todennäköisyyden erotus itseisarvona.
     */
    public Double erotus(Double random, Double lapsiSolmunTodennäköisyys) {
        Double erotus = random - lapsiSolmunTodennäköisyys;
        return erotus > 0 ? erotus : -erotus;
    }

    /**
     * Metodi laskee kullekin (juuresta katsottuna) lapsenlapsisolmulle
     * frekvensseistä todennäköisyyden sille, että tietty merkki seuraa tiettyä
     * merkkiä/merkkiyhdistelmää (eli juuresta katsottuna lapsisolmua) , ja
     * tallentaa sen lapsenlapsisolmuun. EDELLEEN HIEMAN KESKEN.
     */
    public void laskeFrekvenssistäTodennäköisyys() {
        double todnäk;

        int i = 1;
        for (HashMap.Entry<String, Solmu> en : juuri.solmut.entrySet()) {
            String avain = en.getKey();
            Solmu vanhempi = en.getValue();

            for (Solmu lapsi : vanhempi.solmut.values()) {
                todnäk = (double) lapsi.frekvenssi / vanhempi.frekvenssi;
                lapsi.setTodennäköisyys(todnäk);

                i++;
            }
            i = 1;
        }
    }
}
