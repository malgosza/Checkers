import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        ruchGracza();

    }

    public static String[] plansza() {
        String[] plansza = new String[64];
        int licznik = 0;

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                plansza[i] = "o";
            } else {
                plansza[i] = "Y";
            }
        }

        for (int i = 8; i <24; i++) {
            if (licznik % 8 == 0) {
                licznik = 0;
                if (plansza[i - 1].equals("o")) {
                    plansza[i] = "o";
                    licznik++;
                } else {
                    plansza[i] = "Y";
                    licznik++;
                }
            } else {
                licznik++;
                if (plansza[i - 1].equals("o")) {
                    plansza[i] = "Y";
                } else {
                    plansza[i] = "o";
                }
            }
        }
///////-----------------------------------
        for (int i = 24; i < 40; i++) {
            if (i % 2 == 0) {
                plansza[i] = "o";
            } else {
                plansza[i] = "c";
            }
        }

        ///-----------------------------
        licznik = 0;
        for (int i = 40; i < 48; i++) {
            if (licznik % 8 == 0) {
                licznik = 0;
                if (plansza[i - 1].equals("o")) {
                    plansza[i] = "o";
                    licznik++;
                } else {
                    plansza[i] = "X";
                    licznik++;
                }
            } else {
                licznik++;
                if (plansza[i - 1].equals("o")) {
                    plansza[i] = "X";
                } else {
                    plansza[i] = "o";
                }
            }
        }

        for (int i = 40; i < 64; i++) {
            if (licznik % 8 == 0) {
                licznik = 0;
                if (plansza[i - 1].equals("o")) {
                    plansza[i] = "o";
                    licznik++;
                } else {
                    plansza[i] = "X";
                    licznik++;
                }
            } else {
                licznik++;
                if (plansza[i - 1].equals("o")) {
                    plansza[i] = "X";
                } else {
                    plansza[i] = "o";
                }
            }
        }
        return plansza;
    }

    public static void displayPlansza(String[] plansza) {
        for (int i = 0; i < plansza.length; i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(plansza[i] + " ");
        }
        System.out.println();
    }

    public static void ruchGracza() {
        displayPlansza(plansza());

        String czarny = "Y";
        String bialy = "X";

        String ruch=czarny;
        String [] staraPlansza=plansza();
        while (true) {
            System.out.println("Podaj numer Pola na który chcesz sie przesunac");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();

            String[] plansza = staraPlansza;
            plansza[Integer.parseInt(s)] = ruch;
            ruch=bialy;

            displayPlansza(plansza);

            staraPlansza=plansza;
        }
    }

    // logika ->
}
