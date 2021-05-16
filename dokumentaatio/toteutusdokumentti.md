# Toteutusdokumentti

### Ohjelman yleisrakenne

Ohjelmassa käytetään Markovin ketjuja uusien, luonnollisen kielen mukaisten sanojen generoimiseen. Projektissa käytetty pääasiallinen tietorakenne on trie, jonka solmuihin on
 tallennettu tieto opetusdatan merkkiyhdistelmistä ja niitä seuraavista merkeistä Markovin asteen mukaisesti. Tässä projektissa näitä on rajoitettu niin, että käyttäjä voi valita 2- , 3 - tai 4 - Markovin asteen,
 joiden perusteella uusi sana generoidaan. Lisäksi projektissa käytetään HashMap-, ArrayList - ja Random - toteutuksia.


### Saavutetut aika- ja tilavaativuudet (m.m. O-analyysit pseudokoodista) ja työn mahdolliset puutteet ja parannusehdotukset

Projekti ei nykyisellään ole kovin tehokas, pahimmassa tapauksessa aikavaativuus on O(n^2) ja tilavaativuus puolestaan O(n). Em. aikavaativuus tulee siitä, kun uutta sanaa luodessa lasketaan frekvensseistä todennäköisyydet ja trie -tietorakenteen lapsisolmuja ja niiden 
lehtiä käydään läpi kahdella sisäkkäisellä for -loopilla. Tilavaativuus puolestaan Lista -luokan kasvata -metodista, jossa varataan uusi taulukko, johon kopioidaan edellisen/vanhan taulukon arvot. <br>

 Tehokkuutta voisi hieman parantaa, mikäli hajautustaulu olisi varsinainen hajautustaulu (käyttäen hash -funktiota) ja mikäli frekvensseistä laskettaisiin todennäköisyydet silloin kun uutta opetusdataa on lisätty sovellukseen (eikä joka kerta kun uutta sanaa luodaan, kuten nyt).
  Muita puutteita on esim. regexissä, sillä joissakin tapauksissa generoituihin sanoihin saattaa jäädä ylimäär. "_" -merkki. Muutoinkin muutama metodi on kooltaan liian isoja (tähän toki vaikuttaa kommentointikin), mutta niitä olisi vielä huolellisemmin voinut refaktoroida.
