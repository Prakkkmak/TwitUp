package com.iup.tp.twitup.components.core.views;

import com.iup.tp.twitup.base.file.IMainListener;
import com.iup.tp.twitup.common.BaseView;

import javax.swing.*;

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
        JButton twitListButton = new JButton("Liste des twits");
        this.add(twitListButton);
        twitListButton.addActionListener(e -> doLoadTwitListView());
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

    public void doLoadTwitListView(){
        listeners.forEach(IMainListener::notifyLoadTwitList);
    }
}
