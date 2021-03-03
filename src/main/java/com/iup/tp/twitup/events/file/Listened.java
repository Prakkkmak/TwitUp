package com.iup.tp.twitup.events.file;

import java.util.ArrayList;
import java.util.List;

public abstract class Listened<T> {

    protected List<T> listeners = new ArrayList<>();

    public void addListener(T listener) {
        if(this.equals(listener)){
            System.out.println("Le listener n'a pas été ajouté");
            return;
        }
        listeners.add(listener);
    }
    public void removeListener(T listener){
        listeners.remove(listener);
    }

}
