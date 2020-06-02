import java.util.ArrayList;
import java.util.List;

public class RuchGracza {

    private Plansza plansza;
    private ZawartoscPola typGracza;

    public RuchGracza(Plansza plansza, ZawartoscPola typGracza) {
        this.plansza = plansza;
        this.typGracza = typGracza;
    }

    private ZawartoscPola dajPrzeciwnika() {
        return typGracza == ZawartoscPola.iks ? ZawartoscPola.kol : ZawartoscPola.iks;
    }

    public List<Integer> dajDozwolonePola(int indeksPolaZktoregoRuszam) {

        List<Integer> list = new ArrayList<>();

        list.add(indeksPolaZktoregoRuszam - 9);
        list.add(indeksPolaZktoregoRuszam - 7);
        list.add(indeksPolaZktoregoRuszam + 7);
        list.add(indeksPolaZktoregoRuszam + 9);

        List<Integer> doUsuniecia = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (czyPozaGranicami(list, i) || czyBialy(list, i) || czyZajety(list, i)) {
                doUsuniecia.add(list.get(i));
            }
        }

        for (Integer indeksyDoUsuniecia : doUsuniecia) {
            list.remove(indeksyDoUsuniecia);
        }

        return list;
    }

    private boolean czyZajety(List<Integer> list, int i) {
        return !plansza.getZawartoscPola(list.get(i)).equals(ZawartoscPola.pus);
    }

    private boolean czyBialy(List<Integer> list, int i) {
        return plansza.getColor(list.get(i)).equals(KolorPola.bialy);
    }

    private boolean czyPozaGranicami(List<Integer> list, int i) {
        return list.get(i) < 0 || list.get(i) > 63;
    }

    public boolean poprawnePoleDoRuchu(int indeksPolaZktoregoRuszam) {
        return plansza.getColor(indeksPolaZktoregoRuszam).equals(KolorPola.czarny) &&
                !plansza.getZawartoscPola(indeksPolaZktoregoRuszam).equals(ZawartoscPola.pus) &&
                !zwrocDozwolonePolaDoBiciaiRuchu(indeksPolaZktoregoRuszam).isEmpty();
    }

    public List<Integer> dajPolaDoBiciaPionkow(int indeksPolaZktoregoRuszam) {
        List<Integer> out = new ArrayList<>();
        ZawartoscPola przeciwnik = dajPrzeciwnika();
        if (indeksPolaZktoregoRuszam + 18 <= 63 &&
                indeksPolaZktoregoRuszam + 18 >= 0 &&
                plansza.getColor(indeksPolaZktoregoRuszam + 9).equals(KolorPola.czarny) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 9).equals(przeciwnik) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 18).equals(ZawartoscPola.pus) &&
                plansza.getColor(indeksPolaZktoregoRuszam + 18).equals(KolorPola.czarny)) {
            out.add(indeksPolaZktoregoRuszam + 18);
            
        } else if (indeksPolaZktoregoRuszam + 14 <= 63 &&
                indeksPolaZktoregoRuszam + 14 >= 0 &&
                plansza.getColor(indeksPolaZktoregoRuszam + 7).equals(KolorPola.czarny) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 7).equals(przeciwnik) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 14).equals(ZawartoscPola.pus) &&
                plansza.getColor(indeksPolaZktoregoRuszam + 14).equals(KolorPola.czarny)) {
            out.add(indeksPolaZktoregoRuszam + 14);
        }

        return out;
    }

    public List<Ruch> zwrocDozwolonePolaDoBiciaiRuchu(int indeksPolaZktoregoRuszam) {

        List<Ruch> out = new ArrayList<>();

        List<Integer> ruchy = dajDozwolonePola(indeksPolaZktoregoRuszam);
        List<Integer> bicia = dajPolaDoBiciaPionkow(indeksPolaZktoregoRuszam);

        for (Integer r : ruchy) {
            out.add(new Ruch(indeksPolaZktoregoRuszam, r, Ruch.TypRuchu.ruch));
        }
        for (Integer b : bicia) {
            out.add(new Ruch(indeksPolaZktoregoRuszam, b, Ruch.TypRuchu.bicie));
        }

        return out;
    }
}