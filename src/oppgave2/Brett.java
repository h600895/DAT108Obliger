package oppgave2;


import java.util.ArrayList;
import java.util.LinkedList;

public class Brett {
    private int sleep = 0000;
    private int id = 1;
    private int KAPASITET;
    public Brett(int kapasitet) {
        KAPASITET = kapasitet;
    }

    private LinkedList<Hamburger> brett = new LinkedList<>();


    public int antall() {
        return brett.size();
    }

    public synchronized void leggTil(Hamburger burger, String name) throws InterruptedException {
        while (brett.size() >= KAPASITET) {
            System.out.println(name + "(kokk) klar med hamburger, men brett fullt. Venter!");
            this.wait();
        }
        //Thread.sleep(sleep);
        this.notifyAll();

        burger.addId(id);
        brett.add(burger);
        id++;


        System.out.println(name + "(Kokk) legger til burger" + brett.toString());



    }
    public synchronized Hamburger fjern(String name) throws InterruptedException {
        while (antall() <= 0) {
            System.out.println(name + "(servitør) ønsker å ta hamburger, men brett tomt. Venter!");
            this.wait();
        }
        //Thread.sleep(sleep);
        this.notifyAll();
        Hamburger burger = brett.remove();
        System.out.println(name + "(servitør) tar av burger " + " " + burger + " " + brett.toString());
        return burger;

        /*if (antall() > 0) {
            return brett.remove(0);
        }
        return null;*/
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.brett.size(); i++) {
            str += brett.get(i) + ", ";

        }
        return "(|" + str.substring(0, str.length()-2) + "|)";
    }
}


