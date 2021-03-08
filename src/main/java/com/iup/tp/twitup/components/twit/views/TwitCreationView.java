package com.iup.tp.twitup.components.twit.views;

import com.iup.tp.twitup.components.twit.events.ITwitCreationViewListener;
import com.iup.tp.twitup.common.BaseView;

import javax.swing.*;

public class TwitCreationView extends BaseView<ITwitCreationViewListener> {

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
