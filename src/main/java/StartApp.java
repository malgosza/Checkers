import java.util.List;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        Plansza plansza=new Plansza();
        plansza.ustawianieZawartosciPlanszy();
        displayPlansza(plansza);
        RuchGracza ruch=new RuchGracza(plansza);

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

}
