public class StartApp {
    public static void main(String[] args) {
        Plansza plansza=new Plansza();
        displayPlansza(plansza);

    }

    public static void displayPlansza(Plansza plansza) {
        for (int i = 0; i < plansza.getPlansza().size(); i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(plansza.getIndexPlansza(i) + " ");
        }
    }
    // logika ->
}
