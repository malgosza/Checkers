import java.util.ArrayList;
import java.util.List;

public class RuchGracza {

    public RuchGracza() {
    }

    public List<Integer> ruszanieSiePoPolachGdzieMozna(int indeksPolaZktoregoRuszam, Plansza plansza){

        List<Integer> list = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        list.add(indeksPolaZktoregoRuszam-9);
        list.add(indeksPolaZktoregoRuszam-7);
        list.add(indeksPolaZktoregoRuszam+7);
        list.add(indeksPolaZktoregoRuszam+9);

        List<Integer> doUsuniecia=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)< 0 || list.get(i)>63){
                doUsuniecia.add(list.get(i));
            }
            else if (plansza.getColor(list.get(i)).equals(KolorPola.bialy)){
                doUsuniecia.add(list.get(i));
            }
        }

        for (int i = 0; i < doUsuniecia.size(); i++) {
            list.remove(doUsuniecia.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            if (plansza.getZawartoscPola(list.get(i)).equals(ZawartoscPola.pusty)){
                out.add(list.get(i));
            }
        }
        return out;
    }
}
