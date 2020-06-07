import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class StartApp {
    public static void main(String[] args) {
        Plansza plansza = new Plansza();
        plansza.ustawianieZawartosciPlanszy();
        displayPlansza(plansza);

        ZawartoscPola typGraczaX = ZawartoscPola.iks;
        int iloscFigurPrzeciwnika = zliczaczIloscFigurNaPlanszy(plansza, typGraczaX);

        System.out.println("Zaczynaja iksy");

        ruch(plansza, typGraczaX);
        RuchGracza gracz = new RuchGracza(plansza, typGraczaX);

        ZawartoscPola graczAktualny = gracz.dajPrzeciwnika();//kolko
        displayPlansza(plansza);
        iloscFigurPrzeciwnika = zliczaczIloscFigurNaPlanszy(plansza, graczAktualny);
        System.out.println(graczAktualny +" "+ iloscFigurPrzeciwnika);

        while (iloscFigurPrzeciwnika > 0) {

            System.out.println();
            System.out.println("Teraz ruch: " + graczAktualny);

            ruch(plansza, graczAktualny);
            displayPlansza(plansza);

            graczAktualny = graczAktualny.equals(ZawartoscPola.kol) ? ZawartoscPola.iks : ZawartoscPola.kol;

            iloscFigurPrzeciwnika = zliczaczIloscFigurNaPlanszy(plansza, graczAktualny);
            System.out.println(graczAktualny + " " + " " + iloscFigurPrzeciwnika);
        }

        graczAktualny=graczAktualny.equals(ZawartoscPola.kol) ? ZawartoscPola.iks : ZawartoscPola.kol;
        System.out.println("Wygrał: "+ graczAktualny);
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

    public static void ruch(Plansza plansza, ZawartoscPola pionek) {

        int startIndeks;
        int stopIndeks;
        RuchGracza ruchGracza = new RuchGracza(plansza, pionek);

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Poprawny numer pola którym chcesz sie poruszyc?");
            startIndeks = Integer.parseInt(scan.nextLine());
        } while (!ruchGracza.poprawnePoleDoRuchu(startIndeks));

        List<Ruch> out = ruchGracza.zwrocDozwolonePolaDoBiciaiRuchu(startIndeks);

        List<Integer> listaStopow = new ArrayList<>();
        for (Ruch r : out) {
            listaStopow.add(r.getStop());
        }

        System.out.println("Pola do ruchu: ");
        for (Ruch r : out) {
            System.out.println(r.stop + " " + r.typRuchu);
        }

        do {
            System.out.println("Poprawny numer pola na które chcesz sie przesunac?");
            stopIndeks = Integer.parseInt(scan.nextLine());
        } while (!listaStopow.contains(stopIndeks));

        plansza.setZawartoscPola(stopIndeks, pionek);
        plansza.setZawartoscPola(startIndeks, ZawartoscPola.pus);

        if (abs(stopIndeks - startIndeks) == 14 || abs(stopIndeks - startIndeks) == 18) {
            plansza.setZawartoscPola((stopIndeks + startIndeks) / 2, ZawartoscPola.pus);
        }
    }

    public static int zliczaczIloscFigurNaPlanszy(Plansza plansza, ZawartoscPola pionek) {

        int iloscFigur = 0;

        for (int i = 0; i < plansza.getPlansza().size(); i++) {
            if (plansza.getZawartoscPola(i).equals(pionek)) {
                iloscFigur += 1;
            }
        }

        return iloscFigur;
    }
}