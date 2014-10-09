package br.com.schumaker.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Hudson Schumaker
 */
public class SaveFile {

    public static void createFile(File f, String content) {
        try {
            f.createNewFile();
            FileWriter fileWriter = new FileWriter(f);
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(content);
            buffer.flush();
            buffer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
