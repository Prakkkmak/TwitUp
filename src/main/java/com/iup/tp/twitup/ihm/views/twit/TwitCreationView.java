package com.iup.tp.twitup.ihm.views.twit;

import com.iup.tp.twitup.events.file.ITwitListener;
import com.iup.tp.twitup.ihm.views.BaseView;

import javax.swing.*;

public class TwitCreationView extends BaseView<ITwitListener> {

    protected JTextArea twit;

    public TwitCreationView(){
        super();
        twit = new JTextArea(5, 20);
        twit.setColumns(25);
        twit.setBorder(BorderFactory.createBevelBorder(1));
        gc.gridx = 1;
        gc.gridy = 1;
        this.add(twit, gc);
        JButton sendButton = new JButton("Envoyer");
        sendButton.addActionListener(e -> doCreateTwit(twit.getText()));
        gc.gridx = 1;
        gc.gridy = 2;
        this.add(sendButton, gc);
    }


    public void doCreateTwit(String text) {
        listeners.forEach(e -> e.notifyTwitCreated(text));
    }
}
