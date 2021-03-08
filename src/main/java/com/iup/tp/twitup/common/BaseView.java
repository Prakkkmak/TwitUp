package com.iup.tp.twitup.common;

import com.iup.tp.twitup.components.core.views.comp.Title;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseView<T> extends JPanel{

    protected List<T> listeners;

    protected GridBagConstraints gc;

    public BaseView(){
        this("Titre de base");
    }
    public BaseView(String title){
        listeners = new ArrayList<>();
        setLayout(new GridBagLayout());
        //this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 3;
        gc.weighty = 3;

        gc.gridx = 1;
        gc.gridy = 0;
        this.add(new Title(title), gc);
        //this.add(new Logo());
    }

    public void addListener(T listener){
        if(this.equals(listener)) return;
        listeners.add(listener);
    }

    public void removeListener(T listener){
        listeners.remove(listener);
    }
}
