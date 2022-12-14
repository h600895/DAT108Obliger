package oppgave2;


import java.util.Random;

public class Servitor extends Thread {
    Brett brett;
    String name;
    public Servitor(Brett brett, String name) {
        this.brett = brett;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Random rand = new Random();
                int randint = rand.nextInt(4000) + 2000;

                hentBurger();
                Thread.sleep(randint);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void hentBurger() throws InterruptedException {
        brett.fjern(name);
    }
}
