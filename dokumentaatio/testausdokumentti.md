# Testausdokumentti

### Yksikkötestaus

Projekti sisältää yksikkötestit luokille Solmu, Trie, Markov, Lista ja Hajautustaulu, joissa testataan näiden yksittäisiä metodeja, kuten solmun alustamista oikein ja opetusdatan käsittelyyn liittyviä toiminnallisuuksia (kuten merkkien lisäämistä
, sanan generoimista). Yksikkötestit toteutettiin Javan JUnitia käyttäen.


### Suorituskykytestaus/ muu aiheeseen sopiva testaus

Testausta toteutettiin myös vertailemalla eri kokoisista ja kielisistä aineistoista, sekä eri Markovin asteilla, saatavia generoituja sanoja. Opetusdatana on käytetty 
[Gutenberg -projektin ](https://www.gutenberg.org/) tarjoamia vapaassa levityksessä olevia teoksia. <br>

#### Markovin aste 2, sanan pituus 6

Englanninkielisellä opetusdatalla, jonka koko on n. 12 000 sanaa, saadaan jo generoitua Markovin asteella 2 uusiakin sanoja, vaikkakin kombinaatioita oikean sanan osista ja oikeita sanoja myöskin generoituu erityisesti,
 mitä lyhyemmäksi on valittu generoitavan uuden sanan pituus (esim. 4 merkkiä) ja mitä korkeampi Markovin aste. Eli esim. pidemmällä vaatimuksella (esim. 6 merkkiä) saadaan jo uusia sanoja (oikeitakin sanoja kyllä edelleen ilmestyy suuremmaksi osaksi), kuten "efolin" (Markovin aste 2) ja "potary" (Markovin aste 3). 
 Sananpituudella 6 saadaan Markovin steella 4 pelkkiä osia oikeista sanoista. Eli tätä aineistoa suppeamman kokoisella englanninkielisellä opetusdatalla generoidut sanat ovat siis kopioita tai osia oikeista sanoista. <br>
 
Suomenkielisellä opetusdatalla, jossa n. 19 352 sanaa, vastaavasti Markovin asteella 2 ja sanan pituudella 6, ei kuitenkaan saada vielä generoitua uusia sanoja, vaan osia varsinaisista sanoista. Vaikuttaa siis, että suomenkielen syntaksia mukailevia sanoja generoitaessa tarvitaan isompi opetusdata. Uusia sanoja alkaa vastaavilla spekseillä generoitumaan,
 kun käytetään opetusdataa, jonka koko on n. 25 400 sanaa, kuten esimerkkinä tästä generoitu sana: "etiide".
 

#### Markovin aste 3, sanan pituus 6

Englanninkielisellä opetusdatalla, jonka koko on n. 25 094 sanaa, generoituu sanoja, kuten "glines", "laken" ja "irries". Varsinaisien sanojen tai niiden osien ilmaantuvuus on kuitenkin yleistä. <br>

Suomenkielisellä opetusdatalla, jonka koko n. 112 968 sanaa, saadaan Markovin asteella 3 ja sanan pituudella 6 generoitua uusiakin sanoja, kuten "ituska", "tikina" ja "knoras". Varsinaisien sanojen tai niiden osien ilmaantuvuus on kuitenkin yleistä.


#### Markovin aste 4, sanan pituus 6 
 Englanninkielisellä opetusdatalla, jonka koko on n. 134 784 sanaa, generoituu sanoja, kuten "allust", "mority" ja "ragina". Varsinaisien sanojen tai niiden osien ilmaantuvuus on kuitenkin erittäin yleistä. <br>

 Suomenkielisellä opetusdatalla, jonka koko n. 200 347 sanaa, saadaan Markovin asteella 4 ja sanan pituudella 6 generoitua uusiakin sanoja, kuten "rusotu", "yryyde", "linpeh" ja "tasort". Varsinaisien sanojen tai niiden osien ilmaantuvuus on kuitenkin erittäin yleistä.
 
 
#### Yhteenveto

 Suorituskykytestauksessa kiinnitettiin siis huomiota siihen, minkä kokoinen opetusdataa tarvitaan kullekin projektissa valittavissa oleville Markovin asteille, jotta uusiakin sanoja alkaa generoitumaan. Tässä käytettiin ns. vakiona sanan pituutta 6, 
 mutta testauksen ohessa huomattiin, että mitä pidemmäksi käyttäjä valitsee generoitavan sanan, sitä todennäköisemmin se ei muistuta oikeita sanoja tai sen osia. Lisäksi mitä suurempi Markovin aste, sitä suurempi opetusdata tarvitaan. Kynnyksellä, jossa opetusdatalla saadaan korkeammalla Markovin asteella
  uusiakin sanoja generoitumaan (niin, että varsinaisia sanoja ja niiden osien ilmaantuvuus on yhä yleistä) saadaan pienemmillä asteilla jo tiheämmin uusia sanoja. Huomattiin myös, että suomenkielisiä sanoja generoidessa tarvitaan huomattavasti suurempi opetusdata kuin englanninkielisiä generoidessa (liittynee 
  näiden kielien rakenteesen).