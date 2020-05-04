import java.util.ArrayList;
import java.util.List;

public class Plansza {

    List<Pole> plansza;

    public Plansza(){
        plansza=new ArrayList<>(64);
        // logika inicjalizacyjna
        plansza.set(0, new Pole(0,"bialy"));

        //najpierw inicjalizacja planszy, a dopiero pozniej wypelnic

    }
}
