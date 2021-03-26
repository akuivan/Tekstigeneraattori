package tekstigeneraattori.domain;

public class Trie {

    private Solmu juuri;

    public Trie() {
        juuri = new Solmu();
    }

    public void lisääMerkit(String data, int k) {
        for (int i = 0; i <= data.length() - k; i++) {
            String merkit = data.substring(i, i + k);

            if (!juuri.solmut.containsKey(merkit)) {
                if (i + k >= data.length()) {
                    juuri.solmut.put(merkit, new Solmu());
                    break;
                } else {
                    String seur = String.valueOf(data.charAt(i + k));
                    Solmu uusi = new Solmu();
                    uusi.solmut.put(seur, new Solmu());
                    juuri.solmut.put(merkit, uusi);
                }
            } else {
                juuri.solmut.get(merkit).kasvataFrekvenssiä();
            }
        }
    }

    public String haeMerkki(String haettava) {
        for (String solmu : juuri.solmut.keySet()) {
            if (solmu.equals(haettava)) {
                return solmu;
            }
        }
        return null;
    }

}
