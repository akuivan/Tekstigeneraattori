# Tekstigeneraattori

Opinto-ohjelma: tietojenkäsittelytieteen kandidaatti (TKT)
Kielivalinta: Suomi

Tekstigeneraattorin tarkoitus on luoda uusia, luonnollisen kielen kaltaisia sanoja tai lauseita. Ohjelmointikielenä käytössä on Java.

### Algoritmit ja tietorakenteet

Algoritmit ja tietorakenteet, joita työssä toteutetaan ovat Markovin ketjut, trie (eng. prefix tree) ja ((mahdollisesti) taulukko. Markovin ketjut sopivat hyvin tekstin generoimiseen (siinä seur. tila riippuu edellisestä/edellisistä tiloista) ja trie -tietorakenteeseen pystytään tallentamaan tietoa siitä, mikä kirjain seuraa toista kirjainta ja näiden frekvenssit.

### Syötteet ja niiden käyttö

Ohjelma saa käyttäjältä syötteenä .txt -muotoisen tiedoston, käsittelee sen sisältämän tekstin ja muodostaa tämän perusteella uusia luonnollisen kielen kaltaisia sanoja tai lauseita.


### Tavoitteena olevat aika- ja tilavaativuudet

O((n^2)m)

### Lähteet
