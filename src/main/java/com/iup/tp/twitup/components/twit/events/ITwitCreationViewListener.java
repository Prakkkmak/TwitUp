package com.iup.tp.twitup.components.twit.events;

import com.iup.tp.twitup.common.ICancelListener;

public interface ITwitCreationViewListener extends ICancelListener {
    default void notifyTwitCreated(String content){}
}
