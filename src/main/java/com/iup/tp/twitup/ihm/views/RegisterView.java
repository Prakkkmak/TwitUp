package com.iup.tp.twitup.ihm.views;

import com.iup.tp.twitup.events.file.IAccountListener;
import com.iup.tp.twitup.events.file.IRegisterListener;
import com.iup.tp.twitup.ihm.custom.loginComponents.PasswordInput;
import com.iup.tp.twitup.ihm.custom.loginComponents.TagInput;
import com.iup.tp.twitup.ihm.custom.loginComponents.UsernameInput;
import com.iup.tp.twitup.ihm.views.BaseView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterView extends BaseView<IAccountListener> {

    UsernameInput usernameInput = new UsernameInput();
    TagInput tagInput = new TagInput();
    PasswordInput passwordInput = new PasswordInput();
    public RegisterView(){
        super();
        this.add(usernameInput);
        this.add(tagInput);
        this.add(passwordInput);
        JButton registerButton = new JButton("S'enregister");
        this.add(registerButton);
        registerButton.addActionListener(e -> doRegister(usernameInput.getTextInput(),tagInput.getTextInput(),passwordInput.getTextInput()));
        JButton cancelButton = new JButton("Cancel");
        this.add(cancelButton);
        cancelButton.addActionListener(e -> doCancel());
    }

    public void doRegister(String username, String tag, String password) {
        listeners.forEach((c) -> c.notifyRegister(username, tag, password));
    }

    public void doCancel() {
        listeners.forEach(IAccountListener::notifyCancel);
    }
}
