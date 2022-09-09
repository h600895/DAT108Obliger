package oppgave3;

import oppgave2.Brett;
import oppgave2.Kokk;
import oppgave2.Servitor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    static int index = 1;
    public static void main(String[] args) {

        //Mangler en handler om det ikke er mulig å utføre metoden
        //En vente-del

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        BlockingQueue<Hamburger> koe = new LinkedBlockingQueue<>(KAPASITET);

        for (String navn: kokker) {
            System.out.println("Oppretter kokk");
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            koe.put(new Hamburger(index));
                            index++;
                            System.out.println(navn + " la på en burger: "+ koe.size() + " " + koe.toString());

                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }.start();


            /*new Thread(() -> {
                while (true) {
                    try {
                        koe.put(new Hamburger(1));
                        System.out.println("Hamburger lagt på brettet" + koe.toString());

                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();*/
        }
        for (String navn: servitorer) {
            System.out.println("Oppretter servitør");
            new Thread(() -> {
                while (true) {
                    try {
                        Hamburger burger = koe.take();
                        System.out.println(navn + " tar av en burger " + burger  + ": " + koe.size() + " " + koe.toString());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

    }
}


/*
* Lager tråder med servitører som tar hamburgere ut av køen .take
* Lager tråder med kokker som legger til hanburfere i køen .put
*
*
*
* */
