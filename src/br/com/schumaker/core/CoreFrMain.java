package br.com.schumaker.core;

import br.com.schumaker.entity.Originator;
import br.com.schumaker.entity.TextStateCare;
import br.com.schumaker.gfx.FrMain;
import java.util.ArrayList;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 * @since 11/09/2014
 * Usando padrão Singleton (Lazy)
 */
public class CoreFrMain {

    private static CoreFrMain instance = null;
    private final ArrayList<Originator.Text> state;
    private final Originator originator;
    private int k;
    private FrMain frMain;

    private CoreFrMain() {
        state = new ArrayList<>();
        originator = new Originator();
        k = 0;
    }

    public static synchronized CoreFrMain getInstance() {
        if (instance == null) {
            instance = new CoreFrMain();
        }
        return instance;
    }

    public void controlZ() {
        k--;
        if (k >= 0) {
            originator.restoreFromMemento(state.get(k));
            frMain.setTextToPane(originator.get().getText());
            frMain.setFontTextPane(originator.get().getFont());
        } else {
            k = 0;
        }
    }

    public void controlY() {
        k++;
        if (k < state.size()) {
            originator.restoreFromMemento(state.get(k));
            frMain.setTextToPane(originator.get().getText());
            frMain.setFontTextPane(originator.get().getFont());
        } else {
            k = state.size() - 1;
        }
    }
    
    public String getText(){
        return frMain.getTextFromPane();
    }
    
    public void keep() {
        originator.set(new TextStateCare(frMain.getTextFromPane(), frMain.getFontTextPane()));
        state.add(originator.saveToMemento());
        k = state.size();
    }

    public void Exit() {
        System.exit(0);
    }

    public void setFrMain(FrMain frMain) {
        this.frMain = frMain;
    }
}
