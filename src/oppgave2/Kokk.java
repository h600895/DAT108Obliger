package oppgave2;


import java.util.Random;

public class Kokk extends Thread {
    String name;
    Brett brett;

    @Override
    public void run() {
        while (true) {
            try {
                lagBurger();
                Random rand = new Random();
                int randint = rand.nextInt(4000) + 2000;
                Thread.sleep(randint);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public Kokk(Brett brett, String name) {
        this.brett = brett;
        this.name = name;
    }

    public void lagBurger() throws InterruptedException {
        brett.leggTil(new Hamburger(), name);

    }
}
