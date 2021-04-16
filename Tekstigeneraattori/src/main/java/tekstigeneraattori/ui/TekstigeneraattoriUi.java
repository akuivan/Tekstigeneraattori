package tekstigeneraattori.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tekstigeneraattori.domain.Trie;

/**
 * Graafinen käyttöliittymä ja sen käynnistys.
 *
 */
public class TekstigeneraattoriUi extends Application {

    VBox vBox;
    Trie trie;

    /**
     * Metodi käynnistää graafisen käyttöliittymän.
     *
     * @param args on Main luokan antama muuttuja.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metodi sisältää graafisen käyttöliittymän toiminnallisuutta ja
     * komponentteja.
     *
     * @param pääikkuna on ikkunaa kuvaava Stage -olio.
     */
    @Override
    public void start(Stage pääIkkuna) throws Exception {
        // alusta trie -tietorakenne
        trie = new Trie();

        //graafiset komponentit ja niiden toiminta
        pääIkkuna.setTitle("Sanageneraattori");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        Button liitäTiedostoNappi = new Button("Valitse txt.tiedosto");
        liitäTiedostoNappi.setOnAction(e -> {
            File valittuTiedosto = fileChooser.showOpenDialog(pääIkkuna);
            lueTiedosto(valittuTiedosto);
        });

        VBox vbox = new VBox();

        Text ohje1 = new Text("Valitse yksi seuraavista Markovin asteista");
        Text ohje2 = new Text("Valitse generoitavan sanan pituus (kirjoita numero)");
        CheckBox checkBox1 = new CheckBox("aste 2");
        CheckBox checkBox2 = new CheckBox("aste 3");
        CheckBox checkBox3 = new CheckBox("aste 4");
        Button luoSanaNappi = new Button("Luo sana");
        Button palaaTakaisin = new Button("Palaa takaisin");
        TextField tekstikenttäPituudelle = new TextField();
        TextField tekstikenttäUudelleSanalle = new TextField();

        vbox.getChildren().add(ohje1);
        vbox.getChildren().add(checkBox1);
        vbox.getChildren().add(checkBox2);
        vbox.getChildren().add(checkBox3);
        vbox.getChildren().add(ohje2);
        vbox.getChildren().add(tekstikenttäPituudelle);
        vbox.getChildren().add(luoSanaNappi);
        vbox.getChildren().add(tekstikenttäUudelleSanalle);
        vbox.getChildren().add(palaaTakaisin);

        Scene generointiNäkymä = new Scene(vbox);

        Button generoiSanaNappi = new Button("Generoi sana");
        generoiSanaNappi.setOnAction(e -> {
            pääIkkuna.setScene(generointiNäkymä);
        });

        // käyttäjä voi kirjoittaa vain nroita tekstikenttään
        tekstikenttäPituudelle.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> tarkasteltava,
                    String vanhaArvo, String uusiArvo) {
                if (!uusiArvo.matches("\\d*")) {
                    tekstikenttäPituudelle.setText(uusiArvo.replaceAll("[^\\d]", ""));
                }
            }
        });

        luoSanaNappi.setOnAction(e -> {
            int pituus = Integer.valueOf(tekstikenttäPituudelle.getText());
            int k = valittuMarkovinAste(checkBox1, checkBox2, checkBox3);
            tekstikenttäUudelleSanalle.setText(trie.luoSana(k, pituus));

        });

        this.vBox = new VBox(liitäTiedostoNappi, generoiSanaNappi);
        Scene aloitusNäkymä = new Scene(vBox, 50, 50);

        palaaTakaisin.setOnAction(e -> {
            pääIkkuna.setScene(aloitusNäkymä);
        });

        pääIkkuna.setScene(aloitusNäkymä);
        pääIkkuna.show();
    }

    /**
     * Metodi lukee käyttäjän avamaan tekstitiedoston.
     *
     * @param valittu on valittu txt.tiedosto.
     *
     */
    public void lueTiedosto(File valittu) {
        try ( BufferedReader lukija = new BufferedReader(new FileReader(valittu))) {
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
     * Metodi tarkistaa, minkä ruudun, eli Markovin asteen, käyttäjä on
     * valinnut.
     *
     *
     * @param checkbox1 on ensimmäinen ruutu (Markovin aste 2).
     *
     * @param checkbox2 on toinen ruutu (Markovin aste 3).
     *
     * @param checkbox3 on kolmas ruutu (Markovin aste 4).
     *
     * @return valittu Markovin aste.
     */
    private int valittuMarkovinAste(CheckBox checkbox1, CheckBox checkbox2,
            CheckBox checkbox3) {
        int k = 0;

        if (checkbox1.isSelected()) {
            k = 2;
        } else if (checkbox2.isSelected()) {
            k = 3;
        } else if (checkbox3.isSelected()) {
            k = 4;
        }
        return k;
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
            // ja jos sana onkin rivinvaihto tai numeerinen
            if (sana.isEmpty() || onNumero(sana)) {
                indeksi++;
                continue; // sitä ei tallenneta.
            }
            // muutoin lisää ko. sana trie -rakenteeesen
            trie.lisääMerkit(sana, 2);
            trie.lisääMerkit(sana, 3);
            trie.lisääMerkit(sana, 4);
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

}
