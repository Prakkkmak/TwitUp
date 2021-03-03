package com.iup.tp.twitup.core.controllers;

import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.file.ICancelListener;
import com.iup.tp.twitup.events.file.ITwitListener;
import com.iup.tp.twitup.events.file.Listened;

import java.util.UUID;

public class TwitController extends Listened<ITwitListener> implements ITwitListener {

    IDatabase mDatabase;

    public TwitController(IDatabase mDatabase){
        this.mDatabase = mDatabase;
    }

    @Override
    public void notifyTwitCreated(String content) {
        Twit twit = new Twit(Twitup.userConnected,  content);
        mDatabase.addTwit(twit);
        doTwitCreated(twit);
        doCancel();
    }

    protected void doTwitCreated(Twit twit){
        listeners.forEach(e -> e.notifyTwitCreated(twit));
    }

    protected void doCancel(){
        listeners.forEach(ICancelListener::notifyCancel);
    }

}
