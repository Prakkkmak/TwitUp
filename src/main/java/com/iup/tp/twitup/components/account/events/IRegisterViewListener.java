package com.iup.tp.twitup.components.account.events;

public interface IRegisterViewListener {
    default void notifyRegister(String username, String tag, String password){}
    default void notifyCancel(){}
}
