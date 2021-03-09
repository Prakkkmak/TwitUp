package com.iup.tp.twitup.components.twit.views.comp;

import com.iup.tp.twitup.base.datamodel.Twit;

import javax.swing.*;

public class TwitComponent extends JLabel {
    public TwitComponent(Twit twit){
        setText(twit.getText());
        /*JLabel textLabel = new JLabel(twit.getText());
        JLabel authorLabel = new JLabel(twit.getTwiter().getName());
        this.add(textLabel);
        this.add(authorLabel);*/
    }
}
