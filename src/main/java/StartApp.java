public class StartApp {
    public static void main(String[] args) {
        Plansza plansza=new Plansza();
        plansza.ustawianieZawartosciPlanszy();
        displayPlansza(plansza);

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Numer pola którym chcesz sie poruszyc?");
//        String numerPolaDoZmiany = scan.nextLine();
//
//        Scanner scan2 = new Scanner(System.in);
//        System.out.println("Numer pola na które chcesz sie poruszyc?");
//        String numerPolaNaZmiane = scan2.nextLine();
    }

    public static void displayPlansza(Plansza plansza) {
        for (int i = 0; i < plansza.getPlansza().size(); i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(plansza.getColor(i) + " ");
        }
    }


    public static void ruchGracza(){

    }
    // logika ->
    // numer pola ktory chce ruszyc
    // numer pola na który chce pzresunac pionek
    //sprawdzam zawartosc
    //decyzja czy moge czu nie moge

}
