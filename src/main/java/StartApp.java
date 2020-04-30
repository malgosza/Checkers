public class StartApp {
    public static void main(String[] args) {
        plansza();
    }

    public static void plansza() {
        String[] plansza = new String[64];
        int licznik = 0;

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                plansza[i] = "C";
            } else {
                plansza[i] = "O";
            }
        }

        for (int i = 8; i < plansza.length; i++) {
            if (licznik % 8 == 0) {
                licznik = 0;
                if (plansza[i - 1].equals("C")) {
                    plansza[i] = "C";
                    licznik++;
                } else {
                    plansza[i] = "O";
                    licznik++;
                }
            } else {
                licznik++;
                if (plansza[i - 1].equals("C")) {
                    plansza[i] = "O";
                } else {
                    plansza[i] = "C";
                }
            }
        }
    }
}