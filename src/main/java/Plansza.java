import java.util.ArrayList;
import java.util.List;

public class Plansza {

    List<Pole> plansza;

    public Plansza() {
        plansza = new ArrayList<>();

        // logika inicjalizacyjna
        for (int i = 0; i < 64; i++) {

            int licznik = (i / 8) % 2;

            KolorPola kolorPola = (i % 2 == licznik)
                    ? KolorPola.czarny
                    : KolorPola.bialy;

            plansza.add(new Pole(i, kolorPola));

        }

        //najpierw inicjalizacja planszy, a dopiero pozniej wypelnic

    }
}
