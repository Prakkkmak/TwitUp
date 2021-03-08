package com.iup.tp.twitup.components.account.events;

public interface ILoginViewListener {
    default void notifyLogin(String username, String password){}
    default void notifyCancel(){}
}
