import java.util.ArrayList;
import java.util.List;

public class RuchGracza {

    Plansza plansza;

    public RuchGracza(Plansza plansza) {
        this.plansza = plansza;
    }

    public List<Integer> dajDozwolonePola(int indeksPolaZktoregoRuszam) {

        List<Integer> list = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        list.add(indeksPolaZktoregoRuszam - 9);
        list.add(indeksPolaZktoregoRuszam - 7);
        list.add(indeksPolaZktoregoRuszam + 7);
        list.add(indeksPolaZktoregoRuszam + 9);

        List<Integer> doUsuniecia = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0 || list.get(i) > 63) {
                doUsuniecia.add(list.get(i));
            } else if (plansza.getColor(list.get(i)).equals(KolorPola.bialy)) {
                doUsuniecia.add(list.get(i));
            }
        }

        for (int i = 0; i < doUsuniecia.size(); i++) {
            list.remove(doUsuniecia.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            if (plansza.getZawartoscPola(list.get(i)).equals(ZawartoscPola.pusty) ||
                    plansza.getColor(list.get(i)).equals(KolorPola.czarny)) {
                out.add(list.get(i));
            }
        }

        System.out.println("Pola po ktorych mozesz sie poruszac: ");
        for (int i = 0; i < out.size(); i++) {
            System.out.print(out.get(i) + " ");
        }
        System.out.println();

        return out;
    }

    public boolean poprawnePoleDoRuchu(int indeksPolaZktoregoRuszam) {
        if (plansza.getColor(indeksPolaZktoregoRuszam).equals(KolorPola.czarny) &&
                (plansza.getZawartoscPola(indeksPolaZktoregoRuszam).equals(ZawartoscPola.iks) ||
                        plansza.getZawartoscPola(indeksPolaZktoregoRuszam).equals(ZawartoscPola.kolko)) &&
                zwrocDozwolonePolaDoBiciaiRuchu(indeksPolaZktoregoRuszam).size() > 0) {
            return true;
        }
        return false;
    }

    //zakladam, ze gram kolkiem
    public List<Integer> dajPolaDoBiciaPionkow(int indeksPolaZktoregoRuszam) {
        List<Integer> out = new ArrayList<>();

        if (plansza.getColor(indeksPolaZktoregoRuszam + 9).equals(KolorPola.czarny) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 9).equals(ZawartoscPola.iks) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 18).equals(ZawartoscPola.pusty) &&
                plansza.getColor(indeksPolaZktoregoRuszam + 18).equals(KolorPola.czarny)) {
            out.add(indeksPolaZktoregoRuszam + 18);
        } else if (plansza.getColor(indeksPolaZktoregoRuszam + 7).equals(KolorPola.czarny) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 7).equals(ZawartoscPola.iks) &&
                plansza.getZawartoscPola(indeksPolaZktoregoRuszam + 14).equals(ZawartoscPola.pusty) &&
                plansza.getColor(indeksPolaZktoregoRuszam + 14).equals(KolorPola.czarny)) {
            out.add(indeksPolaZktoregoRuszam + 14);
        }

        return out;
    }

    public List<Integer> zwrocDozwolonePolaDoBiciaiRuchu(int indeksPolaZktoregoRuszam) {
        List<Integer> out = new ArrayList<>();

        out.addAll(dajDozwolonePola(indeksPolaZktoregoRuszam));
        out.addAll(dajPolaDoBiciaPionkow(indeksPolaZktoregoRuszam));
        return out;
    }

    public void ruchGracza(int indeksPolaZktoregoRuszam, int indeksPolaNaKtoreRuszam ){
        if (poprawnePoleDoRuchu(indeksPolaZktoregoRuszam)==true){
            plansza.setZawartoscPola(indeksPolaZktoregoRuszam,ZawartoscPola.pusty);
            if (dajDozwolonePola(indeksPolaZktoregoRuszam).size()>0){
                plansza.setZawartoscPola(indeksPolaNaKtoreRuszam, ZawartoscPola.kolko);
            }
            //bicie
            else {
                plansza.setZawartoscPola(indeksPolaNaKtoreRuszam,ZawartoscPola.kolko);
                if (indeksPolaZktoregoRuszam+14==indeksPolaNaKtoreRuszam){
                    plansza.setZawartoscPola(indeksPolaZktoregoRuszam+7,ZawartoscPola.pusty);
                }
                else {
                    plansza.setZawartoscPola(indeksPolaZktoregoRuszam+9,ZawartoscPola.pusty);
                }
            }
        }
        else {
            System.out.println("Niemozliwy ruch");
        }
    }
    //bicia
    //obiekt Gracz
}