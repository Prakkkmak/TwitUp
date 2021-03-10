package com.iup.tp.twitup.components.twit.controller;

import com.iup.tp.twitup.base.core.EntityManager;
import com.iup.tp.twitup.base.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.base.datamodel.User;
import com.iup.tp.twitup.components.core.views.TwitupFrame;
import com.iup.tp.twitup.components.twit.events.ITwitCreationListener;
import com.iup.tp.twitup.components.twit.events.ITwitCreationViewListener;
import com.iup.tp.twitup.components.core.controller.Twitup;
import com.iup.tp.twitup.base.datamodel.IDatabase;
import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.common.ICancelListener;
import com.iup.tp.twitup.components.twit.events.ITwitListListener;
import com.iup.tp.twitup.components.twit.events.ITwitListener;
import com.iup.tp.twitup.common.Listened;
import com.iup.tp.twitup.components.twit.models.TwitModel;
import com.iup.tp.twitup.components.twit.views.TwitCreationView;
import com.iup.tp.twitup.components.twit.views.TwitListView;

public class TwitController extends Listened<ITwitListener> implements ITwitCreationListener, ITwitListListener, IDatabaseObserver {

    protected EntityManager manager;
    protected TwitModel model;

    protected TwitCreationController twitCreationController;
    protected TwitListController twitListController;

    public TwitController(EntityManager manager, IDatabase database){
        this.twitCreationController = new TwitCreationController(manager);
        this.twitCreationController.addListener(this);
        this.twitListController = new TwitListController();
        this.twitListController.addListener(this);
        this.manager = manager;
        this.model = new TwitModel(database);
    }

    public TwitModel getModel(){
        return this.model;
    }

    public TwitCreationView openCreation(){
        TwitCreationView view = new TwitCreationView();
        view.addListener(this.twitCreationController);
        return view;
    }

    public TwitListView openList(){
        TwitListView view = new TwitListView(model);
        view.addListener(this.twitListController);
        model.addObserver(view);
        return view;
    }

    @Override
    public void notifyTwitCreated(Twit twit) {
        doTwitCreated(twit);
    }

    @Override
    public void notifyCancel(){
        doCancel();
    }

    protected void doTwitCreated(Twit twit){
        listeners.forEach(e -> e.notifyTwitCreated(twit));
    }
    protected void doCancel(){
        listeners.forEach(ICancelListener::notifyCancel);
    }

    @Override
    public void notifyTwitAdded(Twit addedTwit) {
        this.model.addTwit(addedTwit);
    }

    @Override
    public void notifyTwitDeleted(Twit deletedTwit) {

    }

    @Override
    public void notifyTwitModified(Twit modifiedTwit) {

    }

    @Override
    public void notifyUserAdded(User addedUser) {

    }

    @Override
    public void notifyUserDeleted(User deletedUser) {

    }

    @Override
    public void notifyUserModified(User modifiedUser) {

    }
}
