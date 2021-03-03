package com.iup.tp.twitup.events.file;

import com.iup.tp.twitup.datamodel.User;

public interface IAccountListener extends ICancelListener {
    default void notifyLogin(String username, String password){}
    default void notifyLogin(User user){}
    default void notifyRegister(String username, String tag, String password){}
    default void notifyRegister(User user){}


}
