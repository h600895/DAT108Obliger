package oppgave1;

public class TraadPrint extends Thread{
    StringHandler obj;
    String exitWord = "quit";
    public TraadPrint(StringHandler obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        String str = "";
        while (!str.equals(exitWord)) {
            str = obj.getStr();
            System.out.println(str);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
