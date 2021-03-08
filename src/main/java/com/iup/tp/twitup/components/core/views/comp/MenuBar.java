package com.iup.tp.twitup.components.core.views.comp;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuBar extends JMenuBar {
    private JMenu quit;
    private JMenu aPropos;
    private JOptionPane aProposPane;
    public MenuBar(){
        this.aProposPane = new AProposFrame();
        this.quit = new JMenu("Quitter");
        this.add(this.quit);
        this.aPropos = new JMenu("A propos");
        this.add(this.aPropos);
        initListener();
    }

    private void initListener(){
        this.quit.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.exit(0);
            }
            @Override
            public void menuDeselected(MenuEvent e) { }
            @Override
            public void menuCanceled(MenuEvent e) { }
        });
        this.aPropos.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JDialog dialog =  aProposPane.createDialog( "New Topic");
                dialog.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
    }
}
