package oppgave1;

import javax.swing.JOptionPane;

public class ThreadInput extends Thread {
    String exitWord = "quit";
    StringHandler obj;
    public ThreadInput(StringHandler obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        String str = "";
        while (!str.equals(exitWord)) {
            str = JOptionPane.showInputDialog("Skriv en melding, quit for a avslutte");
            obj.setStr(str);


        }


    }
}
