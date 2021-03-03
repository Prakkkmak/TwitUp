package com.iup.tp.twitup.ihm.views.components;

import com.iup.tp.twitup.datamodel.Twit;

import javax.swing.*;

public class TwitComponent extends JFrame {
    public TwitComponent(Twit twit){
        JLabel textLabel = new JLabel(twit.getText());
        JLabel authorLabel = new JLabel(twit.getTwiter().getName());
        this.add(textLabel);
        this.add(authorLabel);
    }
}
