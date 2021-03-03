package com.iup.tp.twitup.ihm.views.login;

import com.iup.tp.twitup.events.file.IAccountListener;
import com.iup.tp.twitup.ihm.custom.loginComponents.PasswordInput;
import com.iup.tp.twitup.ihm.custom.loginComponents.UsernameInput;
import com.iup.tp.twitup.ihm.views.BaseView;

import javax.swing.*;
import java.util.ArrayList;

public class LoginView extends BaseView<IAccountListener> {

    UsernameInput usernameInput = new UsernameInput();
    PasswordInput passwordInput = new PasswordInput();
    public LoginView(){
        super();
        listeners = new ArrayList<>();
        this.add(usernameInput);
        this.add(passwordInput);
        JButton button = new JButton("Se connecter");
        this.add(button);
        button.addActionListener(e -> doLogin(usernameInput.getTextInput(),passwordInput.getTextInput()));
        JButton cancelButton = new JButton("Cancel");
        this.add(cancelButton);
        cancelButton.addActionListener(e -> doCancel());
    }

    public void doLogin(String username, String password) {
        listeners.forEach((c) -> c.notifyLogin(username, password));
    }

    public void doCancel() {
        listeners.forEach(IAccountListener::notifyCancel);
    }
}
