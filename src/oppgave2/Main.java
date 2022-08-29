package oppgave2;

public class Main {
    public static void main(String[] args) {

        //Mangler en handler om det ikke er mulig å utføre metoden
        //En vente-del

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        Brett brett = new Brett(KAPASITET);

        for(String navn: kokker) {
            new Kokk(brett, navn).start();
        }
        for(String navn: servitorer) {
            new Servitor(brett, navn).start();
        }

    }
}
