package br.com.schumaker.core;

import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Hudson Schumaker Singleton Eager
 */
public class FileFilterWritePool implements Pool<FileNameExtensionFilter> {

    private static final FileFilterWritePool INSTANCE = new FileFilterWritePool();
    private final ArrayList<FileNameExtensionFilter> fileFilter;

    private FileFilterWritePool() {
        fileFilter = new ArrayList<>();
        fileFilter.add(new FileNameExtensionFilter("Formato texto", "txt"));
        fileFilter.add(new FileNameExtensionFilter("Formato Hudson Schumaker", "hs"));
    }

    public static FileFilterWritePool getInstance() {
        return INSTANCE;
    }

    @Override
    public FileNameExtensionFilter aquire() {
        if (fileFilter.size() > 0) {
            return fileFilter.remove(0);
        } else {
            return null;
        }
    }

    @Override
    public void release(FileNameExtensionFilter w) {
        fileFilter.add(w);
    }
}
