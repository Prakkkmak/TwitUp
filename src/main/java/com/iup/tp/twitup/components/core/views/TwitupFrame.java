package com.iup.tp.twitup.components.core.views;

import com.iup.tp.twitup.base.file.IMainListener;
import com.iup.tp.twitup.components.core.views.comp.FileChooser;
import com.iup.tp.twitup.components.core.views.comp.MenuBar;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TwitupFrame extends JFrame {
    List<IMainListener> listeners = new ArrayList<>();

    public TwitupFrame(){
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new MainView();
        this.setContentPane(panel);
        this.setJMenuBar(new MenuBar());
    }
    public void printSelectFolder(){
        JFileChooser fileChooser = new FileChooser();
        //panel.add(fileChooser);T
        fileChooser.showOpenDialog(this);
        doInitDir(fileChooser.getSelectedFile());

        System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
    }

    public void setView(JPanel panel){
        setContentPane(panel);
        revalidate();
        repaint();
    }

    public void addListener(IMainListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IMainListener listener) {
        listeners.remove(listener);
    }

    public void doInitDir(File file) {
        listeners.forEach((e) -> e.notifyInitDir(file));
    }
}
