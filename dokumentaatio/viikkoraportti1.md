# Viikkoraportti 1

### Mitä olen tehnyt tällä viikolla?

Olen yrittänyt perehtyä Markovin ketjuihin ja trie -tietorakenteeseen, pohtia miten toteuttaisin frekvenssien tallentamisen/laskemisen tähän rakenteeseen (tai sen ulkopuolelle taulukkoon?). Mallailin tätä trie -tietorakennetta ja tulevaa graafista käyttöliittymää testiprojektin parissa (esim. miten sovellukseen saa ladattua tiedoston ja tämä asia selvisi).

### Miten ohjelma on edistynyt?

Varsinainen ohjelma ei ole edistynyt alustusta pidemmälle.

### Mitä opin tällä viikolla / tänään?

Tällä viikolla pääsin kärryille vähän siitä, miten Markovin ketjut teoriassa toimivat ja mikä trie -tietorakenne on. FileChooserin käyttö tuli myös opittua.

### Mikä jäi epäselväksi tai tuottanut vaikeuksia? 
Epäselväksi jäi kuitenkin edelleen, miten yhdistän nämä kaksi 'logiikkaa' (Markovin ketjut ja trie), eli miten saan tästä triestä (johon olin aikeissa tallentaa vähintään tekstitiedostossa esiintyneet sanat) irti frekvenssit (jotta voisin sitten lähteä generoimaan tekstiä). Olisiko triehin kenties mahdollista laskea ja tallentaa/päivittää jo ajon aikana frekvenssejä vai olisiko järkevämpää tallentaa tekstitiedoston sisältämä data ensin triehin ja sitten vasta lähteä käsittelemään ja laskemaan/tallettamaan frekvenssejä vaikka taulukon avulla? Jos käyttäisin taulukkoa, niin pohdin että sen tulisi olla siinä tapauksessa kaksiulotteinen, jolloin aikavaativuus toisaalta menisi kehnommaksi.
 Vai olisiko järkevämpää tehdä sellainen trie, jonka nodet sisältäisivät oliomuuttujat liittyen frekvensseihin ja jotka täydennettäisiin jälkikäteen jollain metodilla "laske frekvenssit", jossa hyödynnettäisiin trien search -metodia? <br>
 
 Kaikki vinkit ovat ehdottomasti tervetulleita, sillä varsinaisen projektin kanssa alkuun pääseminen on nyt erittäin tahmeaa.

### Mitä teen seuraavaksi?

Seuraavaksi lähden miettimään ja testailemaan näitä edellä mainittuja asioita, rakentamaan sopivaa trietä projektiin.