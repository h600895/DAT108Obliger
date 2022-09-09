package oppgave3;

public class Hamburger {
    private int nr;
    boolean utenOst = true; //xD

    public Hamburger(int nr) {
        this.nr = nr;

    }

    @Override
    public String toString() {
        return "(" + nr + ")";
    }
}
