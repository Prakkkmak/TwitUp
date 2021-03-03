package com.iup.tp.twitup.core.controllers;

import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.file.IAccountListener;
import com.iup.tp.twitup.events.file.Listened;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class AccountController extends Listened<IAccountListener> implements IAccountListener {

    protected IDatabase mDatabase;

    public AccountController(IDatabase database){
        listeners = new ArrayList<>();
        mDatabase = database;
    }

    protected User userExists(String username, String password){
        for (User user : mDatabase.getUsers()) {
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
        Twitup.userConnected = user;
    }

    protected void doRegister(String username, String tag, String password){
        User user = new User(new UUID(0,0), tag, password, username, new HashSet<>(), "");
        mDatabase.addUser(user);
        doLogin(user);
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