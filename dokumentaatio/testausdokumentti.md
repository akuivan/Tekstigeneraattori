# Testausdokumentti

### Yksikkötestaus

Projekti sisältää yksikkötestit luokille Solmu ja Trie, joissa testataan näiden yksittäisiä metodeja, kuten solmun alustamista oikein ja opetusdatan käsittelyyn liittyviä toiminnallisuuksia (kuten merkkien lisäämistä
, sanan generoimista). Yksikkötestit toteutettiin Javan JUnitia käyttäen.


### Suorituskykytestaus/ muu aiheeseen sopiva testaus

Testausta toteutetaan myös vertailemalla eri kokoisista ja kielisistä aineistoista, sekä eri Markovin asteilla, saatavia generoituja sanoja. <br>

Englanninkielisellä opetusdatalla, joka on koottu kahdesta eri kirjasta ja jonka koko yhteensä on n. 12 000 sanaa, saadaan jo generoitua Markovin asteella 2 uusiakin sanoja, vaikkakin kombinaatioita oikean sanan osista ja oikeita sanoja myöskin generoituu erityisesti,
 mitä lyhyemmäksi on valittu generoitavan uuden sanan pituus (esim. 4 merkkiä) ja mitä korkeampi Markovin aste. Eli esim. pidemmällä vaatimuksella (esim. 6 merkkiä) saadaan jo uusia sanoja (oikeitakin sanoja kyllä edelleen ilmestyy suuremmaksi osaksi), kuten "efolin" (Markovin aste 2) ja "potary" (Markovin aste 3). 
 Sananpituudella 6 saadaan Markovin steella 4 pelkkiä osia oikeista sanoista. Eli tätä aineistoa suppeamman kokoisella englanninkielisellä opetusdatalla generoidut sanat ovat siis kopioita tai osia oikeista sanoista.
