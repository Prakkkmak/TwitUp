package com.iup.tp.twitup.components.account.events;

import com.iup.tp.twitup.base.datamodel.User;
import com.iup.tp.twitup.common.ICancelListener;

public interface IAccountListener extends ICancelListener {
    default void notifyLogin(User user){}
    default void notifyRegister(User user){}
}
