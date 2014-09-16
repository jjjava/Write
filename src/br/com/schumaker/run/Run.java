package br.com.schumaker.run;

import br.com.schumaker.core.CoreFrMain;
import br.com.schumaker.gfx.FrMain;

/**
 * @author Hudson Schumaker
 * @version 1.0.2
 * @since 11/09/2014
 */
public class Run {

    public static void main(String args[]) {

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
                CoreFrMain coreFrMain = CoreFrMain.getInstance();
                FrMain frMain = new FrMain();
                coreFrMain.setFrMain(frMain);
                frMain.setVisible(true);
            }
        });
    }
}
