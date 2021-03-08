package com.iup.tp.twitup.components.twit.events;

import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.common.ICancelListener;

public interface ITwitListener extends ICancelListener {
    default void notifyTwitCreated(Twit twit){}
}
