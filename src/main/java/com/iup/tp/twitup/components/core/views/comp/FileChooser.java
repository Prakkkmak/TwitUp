package com.iup.tp.twitup.components.core.views.comp;

import javax.swing.*;

public class FileChooser extends JFileChooser {
    public FileChooser(){
        this.setFileSelectionMode(DIRECTORIES_ONLY);
    }
}
