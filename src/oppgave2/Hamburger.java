package oppgave2;

public class Hamburger {
    private int nr;
    boolean utenOst = true; //xD

    public Hamburger(){

    }
    public void addId(int id) {
        this.nr = id;
    }

    @Override
    public String toString() {
        return "(" + nr + ")";
    }
}
