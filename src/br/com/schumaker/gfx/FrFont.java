package br.com.schumaker.gfx;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 * @since 11/09/2014
 */
public class FrFont extends javax.swing.JFrame {

    private FrMain frMain;
    private Font lastFont;
    private static ArrayList<Font> fonts = new ArrayList<>();
    private static String aFonts[];

    static {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (Font font : ge.getAllFonts()) {
            if (font.canDisplayUpTo(font.getName()) != 0) {
                fonts.add(font);
            }
        }
        aFonts = new String[fonts.size()];
        for (int k = 0; k < fonts.size(); k++) {
            aFonts[k] = fonts.get(k).getName();
        }
    }

    public FrFont(FrMain frMain) {
        this.frMain = frMain;
        this.initComponents();
        this.load();
        if (frMain.getWidth() <= frMain.preferredSize().width) {
            this.setLocation(frMain.getX() + frMain.getWidth() + 1, frMain.getY());
        } else {
            this.setLocationRelativeTo(null);
        }
    }

    private void load() {
        lastFont = frMain.getFontTextPane();
        fCombo.setSelectedItem((String) frMain.getFontTextPane().getName());
        sSize.setValue(frMain.getFontTextPane().getSize());
    }

    private void setUpFont() {
        frMain.setFontTextPane(new Font(fCombo.getSelectedItem().toString(), Font.PLAIN, sSize.getValue()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fCombo = new javax.swing.JComboBox(aFonts);
        jLabel2 = new javax.swing.JLabel();
        sSize = new javax.swing.JSlider();
        btApply = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fonte");
        setResizable(false);

        jLabel1.setText("Fontes:");

        fCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fComboItemStateChanged(evt);
            }
        });

        jLabel2.setText("Tamanho:");

        sSize.setMajorTickSpacing(8);
        sSize.setMaximum(48);
        sSize.setMinimum(8);
        sSize.setMinorTickSpacing(2);
        sSize.setPaintLabels(true);
        sSize.setPaintTicks(true);
        sSize.setValue(8);
        sSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sSizeStateChanged(evt);
            }
        });

        btApply.setText("Aplicar");
        btApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApplyActionPerformed(evt);
            }
        });

        btCancel.setText("Cancelar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sSize, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btApply)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btApply)
                    .addComponent(btCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApplyActionPerformed
        this.setUpFont();
        this.dispose();
    }//GEN-LAST:event_btApplyActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        frMain.setFontTextPane(lastFont);
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void fComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fComboItemStateChanged
        setUpFont();
    }//GEN-LAST:event_fComboItemStateChanged

    private void sSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sSizeStateChanged
        setUpFont();
    }//GEN-LAST:event_sSizeStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btApply;
    private javax.swing.JButton btCancel;
    private javax.swing.JComboBox fCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider sSize;
    // End of variables declaration//GEN-END:variables
}
