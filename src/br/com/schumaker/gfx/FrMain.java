package br.com.schumaker.gfx;

import br.com.schumaker.core.CoreFrMain;
import java.awt.Font;

/**
 * @author Hudson Schumaker
 * @version 1.0.1
 * @since 11/09/2014
 */
public class FrMain extends javax.swing.JFrame {

    public FrMain() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    public String getTextFromPane() {
        return jTextPane.getText();
    }

    public void setTextToPane(String text) {
        jTextPane.setText(text);
    }

    public Font getFontTextPane() {
        return jTextPane.getFont();
    }

    public void setFontTextPane(Font f) {
        jTextPane.setFont(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mSave = new javax.swing.JMenuItem();
        mClose = new javax.swing.JMenuItem();
        mEdit = new javax.swing.JMenu();
        mControlZ = new javax.swing.JMenuItem();
        mControlY = new javax.swing.JMenuItem();
        mFind = new javax.swing.JMenuItem();
        mFormat = new javax.swing.JMenu();
        mFont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HsWrite");

        jTextPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPaneKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane);

        mFile.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mFile.add(jMenuItem1);

        mSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mSave.setText("Salvar");
        mSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSaveActionPerformed(evt);
            }
        });
        mFile.add(mSave);

        mClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        mClose.setText("Fechar");
        mClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCloseActionPerformed(evt);
            }
        });
        mFile.add(mClose);

        jMenuBar1.add(mFile);

        mEdit.setText("Editar");

        mControlZ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mControlZ.setText("Desfazer");
        mControlZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mControlZActionPerformed(evt);
            }
        });
        mEdit.add(mControlZ);

        mControlY.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mControlY.setText("Refazer");
        mControlY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mControlYActionPerformed(evt);
            }
        });
        mEdit.add(mControlY);

        mFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mFind.setText("Localizar");
        mFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFindActionPerformed(evt);
            }
        });
        mEdit.add(mFind);

        jMenuBar1.add(mEdit);

        mFormat.setText("Formatar");

        mFont.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mFont.setText("Fonte");
        mFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFontActionPerformed(evt);
            }
        });
        mFormat.add(mFont);

        jMenuBar1.add(mFormat);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCloseActionPerformed
        CoreFrMain.getInstance().Exit();
    }//GEN-LAST:event_mCloseActionPerformed

    private void mControlZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mControlZActionPerformed
        CoreFrMain.getInstance().controlZ();
    }//GEN-LAST:event_mControlZActionPerformed

    private void mControlYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mControlYActionPerformed
        CoreFrMain.getInstance().controlY();
    }//GEN-LAST:event_mControlYActionPerformed

    private void jTextPaneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPaneKeyPressed
        if (!evt.isControlDown()) {
            CoreFrMain.getInstance().keep();
        }
    }//GEN-LAST:event_jTextPaneKeyPressed

    private void mSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSaveActionPerformed
        CoreFrMain.getInstance().save();
    }//GEN-LAST:event_mSaveActionPerformed

    private void mFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFontActionPerformed
        FrFont frFont = new FrFont(this);
        frFont.setVisible(true);
    }//GEN-LAST:event_mFontActionPerformed

    private void mFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFindActionPerformed
        FrFind frFind = new FrFind();
        frFind.setVisible(true);
    }//GEN-LAST:event_mFindActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CoreFrMain.getInstance().open();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane;
    private javax.swing.JMenuItem mClose;
    private javax.swing.JMenuItem mControlY;
    private javax.swing.JMenuItem mControlZ;
    private javax.swing.JMenu mEdit;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenuItem mFind;
    private javax.swing.JMenuItem mFont;
    private javax.swing.JMenu mFormat;
    private javax.swing.JMenuItem mSave;
    // End of variables declaration//GEN-END:variables
}
