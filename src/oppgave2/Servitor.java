package oppgave2;

public class Servitor extends Thread {
    Brett brett;
    String name;
    public Servitor(Brett brett, String name) {
        this.brett = brett;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            hentBurger();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void hentBurger() {
        Hamburger burger = brett.fjern();
        if (burger != null) {
            System.out.println(name + "(servitør) tar av burger" + brett.toString());
        }
        else {
            System.out.println(name + "(servitør) ønsker å ta hamburger, men brett tomt. Venter!");
        }
    }
}
