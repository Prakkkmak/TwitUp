package com.iup.tp.twitup.components.core.views.comp;

import javax.swing.*;
import java.awt.*;

public class Logo extends JLabel {
    public Logo(){
        ImageIcon image = new ImageIcon("src/resources/images/logoIUP_50.jpg");
        this.setIcon(image);
        Dimension size = this.getPreferredSize();
        this.setBounds(0, 0, size.width, size.height);
    }
}
