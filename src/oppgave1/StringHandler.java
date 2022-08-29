package oppgave1;

public class StringHandler {
    private String str;

    public StringHandler(String str) {
        this.str = str;
    }

    public synchronized void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
