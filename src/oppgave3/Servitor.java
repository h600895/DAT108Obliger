package oppgave3;

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
                hentBurger();
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

    public void hentBurger() throws InterruptedException {
        brett.fjern(name);
    }
}
