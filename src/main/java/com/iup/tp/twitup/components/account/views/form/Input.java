package com.iup.tp.twitup.components.account.views.form;

import javax.swing.*;
import java.awt.*;

public class Input extends JPanel {
    JTextField input;
    public Input(String name){
        setLayout(new BorderLayout());
        JLabel label = new JLabel(name);
        input = new JTextField();
        this.add(label, BorderLayout.BEFORE_LINE_BEGINS);
        this.add(input, BorderLayout.CENTER);
    }
    public String getTextInput(){
        return input.getText();
    }
}
