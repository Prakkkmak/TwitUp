package com.iup.tp.twitup.components.account.controller;

import com.iup.tp.twitup.base.core.EntityManager;
import com.iup.tp.twitup.components.account.events.IAccountListener;
import com.iup.tp.twitup.components.account.events.ILoginViewListener;
import com.iup.tp.twitup.components.account.events.IRegisterViewListener;
import com.iup.tp.twitup.components.account.models.AccountModel;
import com.iup.tp.twitup.components.core.controller.Twitup;
import com.iup.tp.twitup.base.datamodel.IDatabase;
import com.iup.tp.twitup.base.datamodel.User;
import com.iup.tp.twitup.common.Listened;

import java.util.HashSet;
import java.util.UUID;

public class AccountController extends Listened<IAccountListener> implements ILoginViewListener, IRegisterViewListener {

    protected EntityManager entityManager;
    protected AccountModel accountModel;

    public AccountController(EntityManager entityManager, AccountModel accountModel){
        this.entityManager = entityManager;
        this.accountModel = accountModel;
    }

    protected User userExists(String username, String password){
        for (User user : accountModel.getAccounts()) {
            if (user.getName().equals(username) && user.getUserPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    protected void doLogin(String username, String password){
        User user = userExists(username, password);
        if(null == user)  return;
        doLogin(user);
    }

    protected void doLogin(User user){
        listeners.forEach(e -> e.notifyLogin(user));
    }

    protected void doRegister(String username, String tag, String password){
        User user = new User(UUID.randomUUID(), tag, password, username, new HashSet<>(), "");
        entityManager.sendUser(user);
        listeners.forEach(e -> e.notifyRegister(user));
        doCancel();
    }

    public void doCancel(){
        listeners.forEach(IAccountListener::notifyCancel);
    }

    @Override
    public void notifyRegister(String username, String tag, String password) {
       doRegister(username, tag, password);
    }

    @Override
    public void notifyLogin(String username, String password) {
        doLogin(username, password);
        doCancel();
    }

    @Override
    public void notifyCancel() {
        doCancel();
    }

}
