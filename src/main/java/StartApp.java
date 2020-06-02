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

        int indeksPolaZktoregoRuszam;
        RuchGracza ruchGracza=new RuchGracza(plansza,ZawartoscPola.iks);

        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("Poprawny numer pola którym chcesz sie poruszyc?");
            indeksPolaZktoregoRuszam = Integer.parseInt(scan.nextLine());
        }while (!ruchGracza.poprawnePoleDoRuchu(indeksPolaZktoregoRuszam));

        List<Ruch> out =ruchGracza.zwrocDozwolonePolaDoBiciaiRuchu(indeksPolaZktoregoRuszam);

        for (Ruch r: out){
            System.out.println(r.stop + " "+ r.typRuchu);
        }

    }

}
