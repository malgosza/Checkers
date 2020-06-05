import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        Plansza plansza = new Plansza();
        plansza.ustawianieZawartosciPlanszy();
//        plansza.setZawartoscPola(29, ZawartoscPola.kol);
        displayPlansza(plansza);
        int iloscFigurX = 12;
        int iloscFigurO = 12;
        int iloscFigurPrzeciwnika = iloscFigurO;
        ZawartoscPola typGraczaX = ZawartoscPola.iks;

        System.out.println("Zaczynaj iksy");

        ruch(plansza, typGraczaX, iloscFigurPrzeciwnika);
        RuchGracza gracz = new RuchGracza(plansza, typGraczaX);
        ZawartoscPola graczAktualny = gracz.dajPrzeciwnika();//kolko
        displayPlansza(plansza);
        while (iloscFigurPrzeciwnika > 0) {

            System.out.println();
            System.out.println("Teraz ruch: " + graczAktualny);
            System.out.println("Ilosc figur na planszy "+iloscFigurPrzeciwnika);

            iloscFigurPrzeciwnika = graczAktualny.equals(ZawartoscPola.kol) ? iloscFigurX : iloscFigurO;

            ruch(plansza, graczAktualny, iloscFigurPrzeciwnika);
            displayPlansza(plansza);

            graczAktualny = graczAktualny.equals(ZawartoscPola.kol) ? ZawartoscPola.iks : ZawartoscPola.kol;

        }

        System.out.println("Wygrał: +");
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

    public static void ruch(Plansza plansza, ZawartoscPola pionek, int iloscFigurNaPlanszyPrzeciwnika) {

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

        //trzeba sprawdzic czy to ruch czy to bicie

        /*bicie*/
        if (stopIndeks - startIndeks == 14 || stopIndeks - startIndeks == 18) {
            iloscFigurNaPlanszyPrzeciwnika--;
            plansza.setZawartoscPola((stopIndeks + startIndeks) / 2, ZawartoscPola.pus);
            //teraz ma grac przeciwnik
            //zmniejszyc ilosc pionkow przeciwnika
        }
    }
}