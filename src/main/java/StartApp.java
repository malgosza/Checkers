public class StartApp {
    public static void main(String[] args) {
        plansza();
    }

    public static void plansza() {
        String[] plansza = new String[64];
        int licznik = 0;

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                plansza[i] = "O";
            } else {
                plansza[i] = "C";
            }
        }

        for (int i = 8; i < plansza.length; i++) {
            if (licznik % 8 == 0) {
                licznik = 0;
                if (plansza[i - 1].equals("O")) {
                    plansza[i] = "O";
                    licznik++;
                } else {
                    plansza[i] = "C";
                    licznik++;
                }
            } else {
                licznik++;
                if (plansza[i - 1].equals("O")) {
                    plansza[i] = "C";
                } else {
                    plansza[i] = "O";
                }
            }
        }
        
        displayPlansza(plansza);
    }

    public static void displayPlansza(String[] plansza) {
        for (int i = 0; i < plansza.length; i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(plansza[i] + " ");
        }
    }
}
