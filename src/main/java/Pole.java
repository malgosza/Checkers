public class Pole {

    int number;
//    enum
    KolorPola color;

    //enum pusty bialy czarny
    ZawartoscPola fieldContent;

    public Pole(int number, KolorPola color){
        this.number=number;
        this.color=color;
        this.fieldContent=ZawartoscPola.pusty;
    }

    public void ustawPionek(ZawartoscPola fieldContent){
        this.fieldContent=fieldContent;
    }
}