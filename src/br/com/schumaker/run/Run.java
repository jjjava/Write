package br.com.schumaker.run;

import br.com.schumaker.core.CoreFrMain;
import br.com.schumaker.core.chain.Chain;
import br.com.schumaker.core.chain.HelpParameters;
import br.com.schumaker.core.chain.OneParameters;
import br.com.schumaker.core.chain.ZeroParameters;

/**
 * @author Hudson Schumaker
 * @version 1.0.2
 * @since 11/09/2014
 */
public class Run {

    public static void main(final String args[]) {

        //Modo lambda
//        java.awt.EventQueue.invokeLater(() -> {
//            CoreFrMain coreFrMain = CoreFrMain.getInstance();
//            FrMain frMain = new FrMain();
//            coreFrMain.setFrMain(frMain);
//            frMain.setVisible(true);
//        });
        //Modo tradicional 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Chain zeroParam = new ZeroParameters();
                Chain helpParam = new HelpParameters();
                Chain oneParam = new OneParameters();
                zeroParam.setNextChain(helpParam);
                helpParam.setNextChain(oneParam);
                zeroParam.executeProgram(args);
            }
        });
    }
}
