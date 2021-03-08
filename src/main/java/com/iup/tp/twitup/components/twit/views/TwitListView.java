package com.iup.tp.twitup.components.twit.views;

import com.iup.tp.twitup.base.datamodel.Twit;
import com.iup.tp.twitup.components.twit.events.ITwitListListener;
import com.iup.tp.twitup.components.twit.events.ITwitListener;
import com.iup.tp.twitup.common.BaseView;
import com.iup.tp.twitup.components.twit.views.comp.TwitComponent;

import java.util.ArrayList;
import java.util.List;

public class TwitListView extends BaseView<ITwitListListener> {

    List<TwitComponent> twitComponents;

    public TwitListView(List<Twit> twits){
        twitComponents = new ArrayList<>();
        twits.forEach(twit -> {
            TwitComponent twitComponent = new TwitComponent(twit);

        });
    }
}
