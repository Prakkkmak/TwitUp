package com.iup.tp.twitup.components.account.models;

import com.iup.tp.twitup.base.datamodel.IDatabase;
import com.iup.tp.twitup.base.datamodel.User;
import com.iup.tp.twitup.common.Model;

import java.util.List;
import java.util.Set;

public class AccountModel extends Model {

    protected Set<User> users;

    public AccountModel(IDatabase database){
        super(database);
        this.users = database.getUsers();
    }

    public void addAccount(User user){
        this.users.add(user);
        setChanged();
        notifyObservers();
    }

    public void addAccounts(List<User> users){
        this.users.addAll(users);
        setChanged();
        notifyObservers();
    }


    public Set<User> getAccounts(){
        return this.users;
    }

}

