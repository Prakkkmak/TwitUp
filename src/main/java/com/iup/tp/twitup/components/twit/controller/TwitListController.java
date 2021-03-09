package com.iup.tp.twitup.components.twit.controller;

import com.iup.tp.twitup.common.ICancelListener;
import com.iup.tp.twitup.common.Listened;
import com.iup.tp.twitup.components.twit.events.ITwitListListener;
import com.iup.tp.twitup.components.twit.events.ITwitListViewListener;

import java.util.Observer;

public class TwitListController extends Listened<ITwitListListener> implements ITwitListViewListener {
    public void notifyCancel(){
        listeners.forEach(ICancelListener::notifyCancel);
    }
}
