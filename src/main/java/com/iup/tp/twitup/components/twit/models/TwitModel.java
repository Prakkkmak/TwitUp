package com.iup.tp.twitup.components.twit.models;

import com.iup.tp.twitup.base.datamodel.IDatabase;
import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.common.Model;
import com.iup.tp.twitup.common.Observable;

import java.util.List;
import java.util.Set;

public class TwitModel extends Model {

    protected Set<Twit> twits;

    public TwitModel(IDatabase database){
        super(database);
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

