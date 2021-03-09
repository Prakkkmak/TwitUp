package com.iup.tp.twitup.components.twit.controller;

import com.iup.tp.twitup.base.core.EntityManager;
import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.common.Listened;
import com.iup.tp.twitup.components.core.controller.Twitup;
import com.iup.tp.twitup.components.twit.events.ITwitCreationListener;
import com.iup.tp.twitup.components.twit.events.ITwitCreationViewListener;

public class TwitCreationController extends Listened<ITwitCreationListener> implements ITwitCreationViewListener {
    protected EntityManager manager;
    public TwitCreationController(EntityManager entityManager){
        this.manager = entityManager;
    }

    protected void doCreateTwit(String txt){
        //FIXME déscendre le owner
        Twit twit = new Twit(Twitup.userConnected,  txt);
        this.manager.sendTwit(twit);
        listeners.forEach(e->e.notifyTwitCreated(twit));
    }

    @Override
    public void notifyTwitCreated(String txt){
        doCreateTwit(txt);
    }

}
