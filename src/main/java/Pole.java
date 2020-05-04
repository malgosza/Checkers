public class Pole {

    int number;
//    enum
    String color;

    //enum pusty bialy czarny
    String fieldContent;

    public Pole(int number, String color){
        this.number=number;
        this.color=color;
        this.fieldContent="pusty";
    }

    public void ustawPionek(String fieldContent){
        this.fieldContent=fieldContent;
    }
}
