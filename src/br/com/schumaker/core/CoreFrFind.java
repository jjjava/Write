package br.com.schumaker.core;

import br.com.schumaker.gfx.FrFind;
import java.awt.Cursor;
import java.util.StringTokenizer;

/**
 *
 * @author Hudson Schumaker
 */
public class CoreFrFind implements Runnable {

    private Thread t;
    private FrFind frFind;
    private static final CoreFrFind INSTANCE = new CoreFrFind();

    private CoreFrFind() {
    }

    public static CoreFrFind getInstance() {
        return INSTANCE;
    }

    public synchronized void start() {
        t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }

    public void stop() {
        t = null;
    }

    @Override
    public synchronized void  run() {
        frFind.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        String text = CoreFrMain.getInstance().getText();
        String find = frFind.getSearchText();
        StringTokenizer tokens = new StringTokenizer(text);
        System.out.println(tokens.countTokens());
        for (int k = 0; k < tokens.countTokens(); k++) {
            if (find.contains(tokens.nextToken())) {
                System.out.println("Achou");
            }
        }
        frFind.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public FrFind getFrFind() {
        return frFind;
    }

    public void setFrFind(FrFind frFind) {
        this.frFind = frFind;
    }
}
