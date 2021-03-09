package com.iup.tp.twitup.components.twit.events;

import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.common.ICancelListener;

public interface ITwitCreationListener extends ICancelListener {
    void notifyTwitCreated(Twit twit);
}
