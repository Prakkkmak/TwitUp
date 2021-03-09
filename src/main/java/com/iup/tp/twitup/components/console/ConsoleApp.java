package com.iup.tp.twitup.components.console;

import com.iup.tp.twitup.base.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.base.datamodel.User;

public class ConsoleApp implements IDatabaseObserver {
    public ConsoleApp(){
    }

    @Override
    public void notifyTwitAdded(Twit addedTwit) {
        System.out.println("Un twit a été créé");
        System.out.println(addedTwit.getTwiter().getUuid());
        System.out.println(addedTwit.getTwiter().getName());
        System.out.println(addedTwit.getText());
    }

    @Override
    public void notifyTwitDeleted(Twit deletedTwit) {
        System.out.println("Coucou");
    }

    @Override
    public void notifyTwitModified(Twit modifiedTwit) {
        System.out.println("Coucou");
    }

    @Override
    public void notifyUserAdded(User addedUser) {
        System.out.println("Un utilisateur est ajouté " + addedUser.getName());
    }

    @Override
    public void notifyUserDeleted(User deletedUser) {
        System.out.println("Coucou");
    }

    @Override
    public void notifyUserModified(User modifiedUser) {
        System.out.println("Coucou");
    }
}
