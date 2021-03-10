package com.iup.tp.twitup.common;

import com.iup.tp.twitup.base.datamodel.IDatabase;

public abstract class Model extends Observable {

    IDatabase database;

    public Model(IDatabase database){
        this.database = database;
    }

}
