import java.util.List;

public class StartApp {
    public static void main(String[] args) {
        Plansza plansza=new Plansza();
        plansza.ustawianieZawartosciPlanszy();
        displayPlansza(plansza);
        ruch(plansza);

        /*
        RuchGracza ruch=new RuchGracza(plansza,ZawartoscPola.iks);

        Scanner scan = new Scanner(System.in);
        System.out.println("Numer pola którym chcesz sie poruszyc?");
        int start = Integer.parseInt(scan.nextLine());

        while (plansza.getColor(start).equals(KolorPola.bialy)){
            System.out.println("Musisz poruszac sie TYLKO po czarnych! \nNumer pola którym chcesz sie poruszyc?");
            start = Integer.parseInt(scan.nextLine());
        }
        List<Integer> dostepnePola=ruch.dajDozwolonePola(start);


        System.out.println("Numer pola na które chcesz sie poruszyc?");
        int numerPolaNaKtorePrzesuwamFigure = Integer.parseInt(scan.nextLine());
        while (!dostepnePola.contains(numerPolaNaKtorePrzesuwamFigure)){
            System.out.println("Niezgodnie z zasadami! \nNumer pola na które chcesz sie poruszyc?");
            numerPolaNaKtorePrzesuwamFigure = Integer.parseInt(scan.nextLine());
        }
        plansza.setZawartoscPola(numerPolaNaKtorePrzesuwamFigure,ZawartoscPola.iks);
    */
    }

    public static void displayPlansza(Plansza plansza) {
        for (int i = 0; i < plansza.getPlansza().size(); i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(plansza.getColor(i) + "("+plansza.getIndexPlansza(i)+") ");
        }
        System.out.println();
    }

    public static void ruch(Plansza plansza){
        RuchGracza ruchGracza=new RuchGracza(plansza,ZawartoscPola.iks);
        int start = 11;
        Boolean wynik=ruchGracza.poprawnePoleDoRuchu(start);

        //pytac az poda wlasciwe
        List<Ruch> ruchy = ruchGracza.zwrocDozwolonePolaDoBiciaiRuchu(start);
        //podaje numer indeksu na ktory sie przesuwam i az poda tylko z tych dostepnych
        int stop=18;

        //Ktory ruch wybral i w zaleznosci od tego nalezy ustawic
        plansza.setZawartoscPola(start,ZawartoscPola.pusty);
        plansza.setZawartoscPola(stop,ZawartoscPola.kolko);

    }

}
