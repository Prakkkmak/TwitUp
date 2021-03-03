package com.iup.tp.twitup.ihm.views;

import com.iup.tp.twitup.events.file.IMainListener;
import com.iup.tp.twitup.ihm.views.BaseView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainView extends BaseView<IMainListener> {

    public MainView(){
        super();
        JButton registerButton = new JButton("Register");
        this.add(registerButton);
        registerButton.addActionListener(e -> doLoadRegisterView());
        JButton loginButton = new JButton("Se connecter");
        this.add(loginButton);
        loginButton.addActionListener(e -> doLoadLoginView());
        JButton twitButton = new JButton("Twitter");
        this.add(twitButton);
        twitButton.addActionListener(e -> doLoadTwitCreation());
    }

    public void doLoadLoginView() {
        listeners.forEach(IMainListener::notifyLoadLoginPage);
    }

    public void doLoadRegisterView() {
        listeners.forEach(IMainListener::notifyLoadRegisterPage);
    }

    public void doLoadTwitCreation(){
        listeners.forEach(IMainListener::notifyLoadTwitCreation);
    }
}
