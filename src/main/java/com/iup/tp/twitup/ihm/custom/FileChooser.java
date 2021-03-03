package com.iup.tp.twitup.ihm.custom;

import javax.swing.*;

public class FileChooser extends JFileChooser {
    public FileChooser(){
        this.setFileSelectionMode(DIRECTORIES_ONLY);
    }
}
