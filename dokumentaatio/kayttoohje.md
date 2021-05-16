# Käyttöohje

### Miten ohjelma suoritetaan, miten eri toiminnallisuuksia käytetään ja minkä muotoisia syötteitä ohjelma hyväksyy

Lataa tiedosto [Tekstigeneraattori.jar](https://github.com/akuivan/Tekstigeneraattori/releases/tag/v1.0) . <br>

Aloita ensin sovelluksen käyttö lisäämällä sille opetusdataa klikkaamalla painiketta "valitse txt.tiedosto". Tämä avaa valikon, josta voit valita yhden haluamasi txt.tiedoston. Hakemistoon "Tekstigeneraattori/src/txt.resources" on tallennettuna valmiiksi eri 
kokoisia txt.tiedostoja, joita voi halutessaan tässä hyödyntää. Kun olet lisännyt tiedoston, voit halutessasi kasvattaa opetusdataa jatkamalla tiedostojen vaitsemista em. painikkeesta tai vaihtoehtoisesti lisätä opetusdataa myöhemmin. <br>

Tämän jälkeen voit siirtyä sanojen generoimiseen klikkaamalla painiketta "Generoi sana". Valitessa tai vaihtaessa Markovin astetta laita/pidä rasti vain yhdessä haluamassasi Markovin astetta vastaavassa ruudussa.
 Generoitavan sanan pituutta voi vaihtaa kirjoittamalla tekstikenttään numeron, joka vastaa halutun generoidun sanan pituutta. Painiketta "Luo sana" voi näiden valintojen jälkeen klikkailla niin monta kertaa 
 kuin haluaa, ja ko. painikkeen alapuolelle ilmaantuu sovelluksen generoimat sanat.  <br>
 
 Halutessasi voit palata aloitusnäkymään "Palaa takaisin" -painikkeesta, syöttää lisää opetusdataa ja jatkaa sanojen generoimista.

### Missä hakemistossa on jar ja ajamiseen tarvittavat testitiedostot.

- Testit suoritetaan komennolla: **mvn test**
- Testikattavuusraportti luodaan komennolla: **mvn jacoco:report** 

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoc/index.html

#### Suoritettavan jarin generointi
Komento: **mvn package** <br>
generoi hakemistoon target suoritettavan jar-tiedoston Tekstigeneraattori-1.0-SNAPSHOT

#### JavaDoc
JavaDoc generoidaan komennolla: **mvn javadoc:javadoc** <br>
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

#### Checkstyle
Tiedoston checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla:  **mvn jxr:jxr checkstyle:checkstyle** <br>
Mahdollisia virheilmoituksia voi tarkastella avaamalla selaimella tiedoston target/site/checkstyle.html
