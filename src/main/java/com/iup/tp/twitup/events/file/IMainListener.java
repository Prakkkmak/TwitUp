package com.iup.tp.twitup.events.file;

import java.io.File;

public interface IMainListener {
    void notifyInitDir(File dir);
    void notifyLoadLoginPage();
    void notifyLoadRegisterPage();
    void notifyLoadTwitCreation();
}
