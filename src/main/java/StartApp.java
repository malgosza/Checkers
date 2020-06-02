import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        Plansza plansza=new Plansza();
        plansza.ustawianieZawartosciPlanszy();
        displayPlansza(plansza);
        ruch(plansza);
    }

    public static void displayPlansza(Plansza plansza) {
        for (int i = 0; i < plansza.getPlansza().size(); i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(plansza.getZawartoscPola(i)+"("+plansza.getIndexPlansza(i)+") ");
        }
        System.out.println();
    }

    public static void ruch(Plansza plansza){

        int startIndeks;
        int stopIndeks;
        RuchGracza ruchGracza=new RuchGracza(plansza,ZawartoscPola.iks);

        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("Poprawny numer pola którym chcesz sie poruszyc?");
            startIndeks = Integer.parseInt(scan.nextLine());
        }while (!ruchGracza.poprawnePoleDoRuchu(startIndeks));

        List<Ruch> out =ruchGracza.zwrocDozwolonePolaDoBiciaiRuchu(startIndeks);

        List<Integer> listaStopow = new ArrayList<>();
        for(Ruch r: out) {
            listaStopow.add(r.getStop());
        }

        System.out.println("Pola do ruchu: ");
        for (Ruch r: out){
            System.out.println(r.stop + " "+ r.typRuchu);
        }

        do {
            System.out.println("Poprawny numer pola na które chcesz sie przesunac?");
            stopIndeks = Integer.parseInt(scan.nextLine());
        }while(!listaStopow.contains(stopIndeks));

    }
}
