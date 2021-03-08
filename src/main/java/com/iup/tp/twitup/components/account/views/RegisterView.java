package com.iup.tp.twitup.components.account.views;

import com.iup.tp.twitup.components.account.events.IRegisterViewListener;
import com.iup.tp.twitup.components.account.views.form.PasswordInput;
import com.iup.tp.twitup.components.account.views.form.TagInput;
import com.iup.tp.twitup.components.account.views.form.UsernameInput;
import com.iup.tp.twitup.common.BaseView;

import javax.swing.*;

public class RegisterView extends BaseView<IRegisterViewListener> {

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
        listeners.forEach(IRegisterViewListener::notifyCancel);
    }
}
