package br.com.schumaker.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson.sales
 */
public class ReadFile {

    public static String loadFile(File file) {
        BufferedReader in;
        String buffer = "";
        try {
            in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                buffer += line;
            }
            in.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Arquivo:\n" + ex, "Erro.", JOptionPane.ERROR_MESSAGE);
        }
        return buffer;
    }
}
