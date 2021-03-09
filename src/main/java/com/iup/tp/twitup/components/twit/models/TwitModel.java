package com.iup.tp.twitup.components.twit.models;

import com.iup.tp.twitup.base.datamodel.IDatabase;
import com.iup.tp.twitup.base.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.base.datamodel.Twit;

import java.util.List;
import java.util.Observable;
import java.util.Set;

public class TwitModel extends Observable {

    protected Set<Twit> twits;
    protected IDatabase database;

    public TwitModel(IDatabase database){
        super();
        this.database = database;
        this.twits = database.getTwits();
    }

    public void addTwit(Twit twit){
        this.twits.add(twit);
        setChanged();
        notifyObservers();
    }

    public void addTwits(List<Twit> twits){
        this.twits.addAll(twits);
        setChanged();
        notifyObservers();
    }

    public Set<Twit> getTwits(){
        return this.twits;
    }

}

