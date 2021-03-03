package com.iup.tp.twitup.events.file;

import com.iup.tp.twitup.datamodel.Twit;

public interface ITwitListener extends ICancelListener{
    default void notifyTwitCreated(String content){}
    default void notifyTwitCreated(Twit twit){}
}
