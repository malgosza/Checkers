public class StartApp {
    public static void main(String[] args) {
//        displayPlansza();

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
    // logika ->
}
