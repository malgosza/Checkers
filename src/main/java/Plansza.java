import java.util.ArrayList;
import java.util.List;

public class Plansza {

    List<Pole> plansza;

    public Plansza() {
        plansza = new ArrayList<>();

        for (int i = 0; i < 64; i++) {

            int licznik = (i / 8) % 2;

            KolorPola kolorPola = (i % 2 == licznik)
                    ? KolorPola.czarny
                    : KolorPola.bialy;

            plansza.add(new Pole(i, kolorPola));
        }
    }

    public List<Pole> getPlansza() {
        return plansza;
    }

    public int getIndexPlansza(int i) {
        return plansza.get(i).number;
    }

    public KolorPola getColor(int i) {
        return plansza.get(i).color;
    }

    public ZawartoscPola getZawartoscPola(int i) {
        return plansza.get(i).fieldContent;
    }

    public void setZawartoscPola(int i, ZawartoscPola zawartoscPola) {
        Pole numer = plansza.get(i);
        numer.fieldContent = zawartoscPola;
    }

    public void ustawianieZawartosciPlanszy(){
        for (int i = 0; i < 24; i++) {
            setZawartoscPola(i,ZawartoscPola.iks);
        }

        for (int i = 40; i < 64; i++) {
            setZawartoscPola(i,ZawartoscPola.kolko);
        }
    }
}
