package oppgave2;

import java.util.ArrayList;
import java.util.List;



public class Brett {
    private int KAPASITET;
    public Brett(int kapasitet) {
        KAPASITET = kapasitet;
    }

    private ArrayList<Hamburger> brett = new ArrayList<>();

    public int antall() {
        return brett.size();
    }

    public synchronized boolean leggTil(Hamburger burger) {
        if (brett.size() < KAPASITET) {
            brett.add(burger);
            return true;
        }
        return false;
    }
    public synchronized Hamburger fjern() {
        if (antall() > 0) {
            return brett.remove(0);
        }
        return null;
    }

    @Override
    public String toString() {

        return this.brett.toString();
    }
}
