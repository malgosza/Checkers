public class Ruch {
    int start;
    int stop;
    TypRuchu typRuchu;

    public Ruch(int start, int stop, TypRuchu typRuchu) {
        this.start = start;
        this.stop = stop;
        this.typRuchu = typRuchu;
    }

    public enum TypRuchu{
        bicie,
        ruch;
    }
}
