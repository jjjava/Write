package br.com.schumaker.core;

import br.com.schumaker.entity.Originator;
import br.com.schumaker.entity.TextStateCare;
import br.com.schumaker.gfx.FrMain;
import br.com.schumaker.io.SaveFile;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 * @since 11/09/2014 Usando padrão Singleton (Lazy)
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

    public static CoreFrMain getInstance() {
        if (instance == null) {
            synchronized (CoreFrMain.class) {
                if (instance == null) {
                    instance = new CoreFrMain();
                }
            }
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

    public String getText() {
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

    public void save() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        chooser.setDialogTitle("Salvar arquivo");
        chooser.setApproveButtonText("Salvar");
        FileNameExtensionFilter fnef0 = FileFilterWritePool.getInstance().aquire();
        FileNameExtensionFilter fnef1 = FileFilterWritePool.getInstance().aquire();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(fnef0);
        chooser.addChoosableFileFilter(fnef1);

        int sf = chooser.showSaveDialog(null);
        if (sf == JFileChooser.APPROVE_OPTION) {
            SaveFile.createFile(getSelectedFileWithExtension(chooser), CoreFrMain.getInstance().getText());
        }
        FileFilterWritePool.getInstance().release(fnef0);
        FileFilterWritePool.getInstance().release(fnef1);
    }

    public void open() {
    }

    private File getSelectedFileWithExtension(JFileChooser c) {
        File file = c.getSelectedFile();
        if (c.getFileFilter() instanceof FileNameExtensionFilter) {
            String[] exts = ((FileNameExtensionFilter) c.getFileFilter()).getExtensions();
            String nameLower = file.getName().toLowerCase();
            for (String ext : exts) { // check if it already has a valid extension
                if (nameLower.endsWith('.' + ext.toLowerCase())) {
                    return file; // if yes, return as-is
                }
                break;
            }
            file = new File(file.toString() + '.' + exts[0]);
        }
        return file;
    }
}
