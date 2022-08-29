package oppgave2;

public class Kokk extends Thread {
    String name;
    Brett brett;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lagBurger();
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

    public void lagBurger() {
        if (brett.leggTil(new Hamburger(1))) {
            System.out.println(name + "(Kokk) legger til burger" + brett.toString());
        }
        else {
            System.out.println(name + "(kokk) klar med hamburger, men brett fullt. Venter!");
        }

    }
}
