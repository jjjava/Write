package br.com.schumaker.core.chain;

import br.com.schumaker.core.CoreFrMain;
import br.com.schumaker.gfx.FrMain;
import java.io.File;

/**
 *
 * @author Hudson Schumaker
 */
public class OneParameters implements Chain {
    
    private Chain nextInChain;
    
    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }
    
    @Override
    public void executeProgram(String[] params) {
        if (params.length == 1) {
            File file = new File(params[0]);
            if (file.isFile()) {
                FrMain frMain = new FrMain();
                CoreFrMain.getInstance().setFrMain(frMain);
                CoreFrMain.getInstance().open(params[0]);
                frMain.setVisible(true);
            } else {
                System.out.println("Arquivo não valido.");
            }
        } else {
            System.out.println("O Programa funciona com 0 e  1 parametro para path.");
        }
    }
}
