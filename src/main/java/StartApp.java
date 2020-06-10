import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        Plansza plansza = new Plansza();
        plansza.ustawianieZawartosciPlanszy();

        ZawartoscPola aktualnyGracz = ZawartoscPola.iks;
        int ileFigur = 0;
        do{
            displayPlansza(plansza);
            LogikaRuchu logikaRuchu = new LogikaRuchu(plansza, aktualnyGracz);

            Ruch ruch = poprosGraczaOIndeksy(logikaRuchu);
            logikaRuchu.zaaplikujRuchLubBicie(ruch);

            aktualnyGracz = logikaRuchu.dajPrzeciwnika();
            ileFigur = plansza.policzFigury(aktualnyGracz);
        }while(ileFigur > 0);

        System.out.println("Przegral ziomek: " + aktualnyGracz);
    }


    public static void displayPlansza(Plansza plansza) {
        for (int i = 0; i < plansza.getPlansza().size(); i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(plansza.getZawartoscPola(i) + "(" + plansza.getIndexPlansza(i) + ") ");
        }
        System.out.println();
    }

    public static Ruch poprosGraczaOIndeksy(LogikaRuchu logikaRuchu) {

        int startIndeks;
        int stopIndeks;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Poprawny numer pola którym chcesz sie poruszyc?");
            startIndeks = Integer.parseInt(scan.nextLine());
        } while (!logikaRuchu.poprawnePoleDoRuchu(startIndeks));

        List<Ruch> potencjalneRuchy = logikaRuchu.zwrocDozwolonePolaDoBiciaiRuchu(startIndeks);

        List<Integer> listaStopow = new ArrayList<>();
        for (Ruch r : potencjalneRuchy) {
            listaStopow.add(r.getStop());
        }

        System.out.println("Pola do ruchu: ");
        for (Ruch r : potencjalneRuchy) {
            System.out.println(r.stop + " " + r.typRuchu);
        }

        do {
            System.out.println("Poprawny numer pola na które chcesz sie przesunac?");
            stopIndeks = Integer.parseInt(scan.nextLine());
        } while (!listaStopow.contains(stopIndeks));

        return dajWykonanyRuch(potencjalneRuchy, startIndeks, stopIndeks);
    }

    private static Ruch dajWykonanyRuch(List<Ruch> potencjalneRuchy, int startIndeks, int stopIndeks) {
        for (Ruch r: potencjalneRuchy) {
            if(r.stop == stopIndeks && r.start == startIndeks) {
                return r;
            }
        }
        return null;
    }
}