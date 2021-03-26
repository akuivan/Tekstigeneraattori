# Viikkoraportti 2

### Mitä olen tehnyt tällä viikolla?

Osallistuin ohjaukseen ja olen luonut Trie- ja Solmu -luokat sekä pohtinut, tuleeko tämä tekstigeneraattori generoimaan luonnollisia sanoja vai lauseita. Päädyin loppujen lopulta sanoihin, sillä olin ehtinyt luomaan/pyörittelemään datan käsittelyn sillä ajatuksella (vaikka ohjauksessa puhuinkin lauseiden generoimisesta)

### Miten ohjelma on edistynyt?

Ohjelma on edistynyt mielestäni viikkotavoitteiden mukaisesti ja Checkstyle, JavaDoc ja testaus on myös aloitettu. Search -metodi ja sen testaus jäi vielä (varsinaisen todennäköisyyksien laskemisen ja luonnollisten sanojen generoimisen lisäksi) vaiheeseen.

### Mitä opin tällä viikolla / tänään?

Tällä viikolla sain paljon apua ohjauksesta ja sen myötä hahmotan nyt hieman paremmin, miten trieen tallennetaan ("ketjutetaan") solmuja ja markovin (eri asteiset) ketjut.

### Mikä jäi epäselväksi tai tuottanut vaikeuksia? 
Vaikeuksia tuotti datan käsittely, mikäli olisin päätynyt ideaan tehdä lausegeneraattori, ja se miten linkitän solmut toisiinsa ja tallennan tiedon frekvenssistä, mutta näihin sainkin apua hyvin ohjauksesta. <br>

Checkstyle näyttää herjaavan ääkkösistä metodien nimeämisessä. Pitäisikö näiden metodien nimet korjata? (Esim. "KasvataFrekvenssiä" --> "KasvataFrekvenssia")

### Mitä teen seuraavaksi?

Seuraavaksi lähden miettimään, millainen search -metodi mahdollisesti tarvitaan todennäköisyyksien laskemista ajatellen ja ylipäätään miten toteuttaisin tämän laskennan ja koitan saada näistä koodia aikaiseksi. Jos ehdin niin korvaan valmiin HashMapin omalla toteutuksella.