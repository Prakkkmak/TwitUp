package com.iup.tp.twitup.components.twit.controller;

import com.iup.tp.twitup.components.twit.events.ITwitCreationViewListener;
import com.iup.tp.twitup.components.core.controller.Twitup;
import com.iup.tp.twitup.base.datamodel.IDatabase;
import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.common.ICancelListener;
import com.iup.tp.twitup.components.twit.events.ITwitListener;
import com.iup.tp.twitup.common.Listened;

public class TwitController extends Listened<ITwitListener> implements ITwitCreationViewListener {

    IDatabase mDatabase;

    public TwitController(IDatabase mDatabase){
        this.mDatabase = mDatabase;
    }

    protected void doTwitCreated(Twit twit){
        listeners.forEach(e -> e.notifyTwitCreated(twit));
    }

    @Override
    public void notifyTwitCreated(String content) {
        Twit twit = new Twit(Twitup.userConnected,  content);
        mDatabase.addTwit(twit);
        doTwitCreated(twit);
        doCancel();
    }

    protected void doCancel(){
        listeners.forEach(ICancelListener::notifyCancel);
    }

}
