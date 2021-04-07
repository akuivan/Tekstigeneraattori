package tekstigeneraattori.domain;

import java.util.HashMap;

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
                Solmu nykyinen = juuri.solmut.get(merkit);
                nykyinen.kasvataFrekvenssiä();
                if (i + k >= data.length()) {
                    break;
                }
                String seuraavaKirjain = String.valueOf(data.charAt(i + k));

                if (nykyinen.solmut.containsKey(seuraavaKirjain)) {
                    nykyinen.solmut.get(seuraavaKirjain).kasvataFrekvenssiä();
                } else {
                    nykyinen.solmut.put(seuraavaKirjain, new Solmu());
                }
            }
        }
    }

    //täst eteenp. koodi vielä kesken:
    // - aloitussanan arpominen? Erikseen sanan aloittaville merkeille/yhdistelmille oma lista/hashmap?
    // - luotavan sanan pituuden mukaan uuden sanan luominen (eli lopettaminen)
    /**
     * Metodi generoi sanan opetusdatan perusteella. EDELLEEN KESKEN.
     *
     * @param aloitus on String -muodossa annettava merkkiyhdistelmä, joka
     * aloittaa sanan.
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
    public String luoTekstiä(String aloitus, int k, int pituus) {
        laskeFrekvenssistäTodennäköisyys(); // laske/päivitä todennäköisyydet
        String välisana = aloitus;
        String uusi = "";
        // valitse niiden ja RANDOM -muuttujan perusteella mahd. seur kirjain 
        // ja lisää se stringiin/stringbuilderiin
        for (HashMap.Entry<String, Solmu> en : juuri.solmut.entrySet()) {
            //aloitus
            if (välisana.equals(en.getKey())) {  //"val"
                String seur = seuraavaMerkki(en.getValue());
                välisana += seur;
            }

            //jatko RIIPPUEN SIITÄ, MIKÄ k on, tarkastele sen perusteella alkioita
            //ja siten arvo lisää uusia kirjaimia perään metodilla seuraavaKirjain
            // lopetus (int pituus muuttujan mukaisesti?)
        }

        return välisana;
    }

    // trien rakenne jos koostuu sanasta "valo" ja k=3:    
//    juuri --> val ---> o
//     |
//      --> alo ---> null
    /**
     * Metodi arpoo seuraavan merkin opetusdatasta saatujen frekvenssien
     * perusteella ja palauttaa sen. EDELLEEN KESKEN.
     *
     * @param solmu on Trie -rakenteen solmu, jota sillä hetkellä tarkastellaan
     * ja jota seuraavaa merkkiä määritellään.
     *
     * @return merkkiyhdistelmää seuraava merkki/kirjain.
     */
    public String seuraavaMerkki(Solmu solmu) {
        double random = Math.random();
        // tai 
//        double random = new Random().nextDouble();
//        System.out.println(random);
        String kirjain = "";
        double lähin = 1.0;
        Solmu lähinSolmu;

        for (HashMap.Entry<String, Solmu> en : solmu.solmut.entrySet()) {
            Solmu lapsi = en.getValue(); //o -solmu
            double erotus = erotus(random, lapsi.todennäköisyys);

            System.out.println(erotus);
            if (erotus <= lähin) {
                lähin = erotus;
                lähinSolmu = lapsi;
                kirjain = en.getKey();
            }

        }
        System.out.println(kirjain);
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
     * tallentaa sen lapsenlapsisolmuun. EDELLEEN KESKEN.
     */
    public void laskeFrekvenssistäTodennäköisyys() {
        double todnäk;

        int i = 1;
        for (HashMap.Entry<String, Solmu> en : juuri.solmut.entrySet()) {
            String avain = en.getKey(); //"val"
            Solmu vanhempi = en.getValue(); //val -solmu

            //lapset
            for (Solmu lapsi : vanhempi.solmut.values()) {
                System.out.println(i);
                System.out.println("lapsi " + lapsi.frekvenssi + " / vanhempi " + vanhempi.frekvenssi);

                todnäk = (double) lapsi.frekvenssi / vanhempi.frekvenssi;
                lapsi.setTodennäköisyys(todnäk); //tämä lisätty

                System.out.println(todnäk);
                System.out.println("----");
                i++;
            }
            i = 1;
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
//    public String haeMerkit(String haettava) {
//        for (String avain : juuri.solmut.keySet()) {
//            if (avain.equals(haettava)) {
//                return avain;
//            }
//        }
//        return null;
//    }
}
