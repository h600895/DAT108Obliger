package oppgave1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String exitWord = "quit";


        StringHandler stringHandler = new StringHandler("Hello World!");

        Thread readThread = new TraadPrint(stringHandler);
        Thread writeThread = new ThreadInput(stringHandler);

        readThread.start();
        writeThread.start();


    }
}
