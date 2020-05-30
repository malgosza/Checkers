import java.util.List;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        Plansza plansza=new Plansza();
        plansza.ustawianieZawartosciPlanszy();
        displayPlansza(plansza);
        RuchGracza ruch=new RuchGracza();

        Scanner scan = new Scanner(System.in);
        System.out.println("Numer pola którym chcesz sie poruszyc?");
        String numerPolaKtorymRuszamPionek = scan.nextLine();
        while (plansza.getColor(Integer.parseInt(numerPolaKtorymRuszamPionek)).equals(KolorPola.bialy)){
            System.out.println("Musisz poruszac sie TYLKO po czarnych! \nNumer pola którym chcesz sie poruszyc?");
            numerPolaKtorymRuszamPionek = scan.nextLine();
        }
        List<Integer> dostepnePola=ruch.ruszanieSiePoPolachGdzieMozna(Integer.parseInt(numerPolaKtorymRuszamPionek),plansza);


        System.out.println("Numer pola na które chcesz sie poruszyc?");
        Scanner scan2 = new Scanner(System.in);
        String numerPolaNaKtorePrzesuwamFigure = scan2.nextLine();
        while (!dostepnePola.contains(Integer.parseInt(numerPolaNaKtorePrzesuwamFigure))){
            System.out.println("Niezgodnie z zasadami! \nNumer pola na które chcesz sie poruszyc?");
            scan2 = new Scanner(System.in);
            numerPolaNaKtorePrzesuwamFigure = scan2.nextLine();
        }
        ruch.przesuniecieFiguryNaWybranePole(Integer.parseInt(numerPolaNaKtorePrzesuwamFigure),plansza,ZawartoscPola.iks);
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
