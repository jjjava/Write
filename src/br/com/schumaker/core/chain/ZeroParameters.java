package br.com.schumaker.core.chain;

import br.com.schumaker.core.CoreFrMain;
import br.com.schumaker.gfx.FrMain;

/**
 *
 * @author Hudson Schumaker
 */
public class ZeroParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 0) {
            FrMain frMain = new FrMain();
            CoreFrMain.getInstance().setFrMain(frMain);
            frMain.setVisible(true);
        } else {
            nextInChain.executeProgram(params);
        }
    }
}
