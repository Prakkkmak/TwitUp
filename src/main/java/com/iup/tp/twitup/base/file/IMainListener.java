package com.iup.tp.twitup.base.file;

import java.io.File;

public interface IMainListener {
    void notifyInitDir(File dir);
    void notifyLoadLoginPage();
    void notifyLoadRegisterPage();
    void notifyLoadTwitCreation();
}
