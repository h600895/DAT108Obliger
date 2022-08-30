package oppgave2;

public class Kokk extends Thread {
    String name;
    Brett brett;

    @Override
    public void run() {
        while (true) {
            try {
                lagBurger();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
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
        brett.leggTil(new Hamburger(1), name);
    }
}
