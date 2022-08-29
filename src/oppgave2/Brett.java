package oppgave2;


import java.util.ArrayList;

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
        String str = "";
        for (int i = 0; i < this.brett.size(); i++) {
            str += this.brett.get(i) + ", ";

        }
        return "(" + str.substring(0, str.length()-2) + ")";
    }
}


