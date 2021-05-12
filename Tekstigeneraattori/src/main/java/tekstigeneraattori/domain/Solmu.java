package tekstigeneraattori.domain;

/**
 * Luo Solmu olion.
 *
 */
public class Solmu {

    Hajautustaulu<String, Solmu> solmut;
    int frekvenssi;
    double todennäköisyys;

    /**
     * Metodi luo solmun, joka sisältää tiedon frekvenssistä (kuinka usein
     * merkkiyhdistelmä esiintyy opetusdatassa) ja HashMapin, jossa on tieto
     * merkkiyhdistelmästä ja linkki seuraavaan solmuun.
     */
    public Solmu() {
        solmut = new Hajautustaulu<>();
        frekvenssi = 1;
    }

    /**
     * Metodi kasvattaa solmun frekvenssiä yhdellä.
     */
    public void kasvataFrekvenssiä() {
        frekvenssi++;
    }

    /**
     * Metodi asettaa solmun todennäköisyys -muuttujaan arvon, joka kertoo
     * jonkun tietyn kirjaimen todennäköisyyden seurata tiettyä
     * merkkiä/merkkiyhdistelmiä.
     *
     * @param todennäköisyys on asetettava arvo.
     */
    public void setTodennäköisyys(Double todennäköisyys) {
        this.todennäköisyys = todennäköisyys;
    }
}
