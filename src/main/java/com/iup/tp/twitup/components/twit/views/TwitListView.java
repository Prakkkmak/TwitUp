package com.iup.tp.twitup.components.twit.views;

import com.iup.tp.twitup.common.ICancelListener;
import com.iup.tp.twitup.common.Observable;
import com.iup.tp.twitup.common.Observer;
import com.iup.tp.twitup.components.twit.events.ITwitListViewListener;
import com.iup.tp.twitup.common.BaseView;
import com.iup.tp.twitup.components.twit.models.TwitModel;
import com.iup.tp.twitup.components.twit.views.comp.TwitComponent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TwitListView extends BaseView<ITwitListViewListener> implements Observer {

    protected List<TwitComponent> twitComponents;
    protected JScrollPane scrollPane;
    protected TwitModel model;
    JPanel viewInScroll;
    public TwitListView(TwitModel model){
        this.model = model;
        twitComponents = new ArrayList<>();
        viewInScroll = new JPanel();
        BoxLayout layout = new BoxLayout(viewInScroll,BoxLayout.Y_AXIS);
        viewInScroll.setLayout(layout);
        this.scrollPane = new JScrollPane(viewInScroll);
        this.scrollPane.createVerticalScrollBar();
        this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.scrollPane.createHorizontalScrollBar();
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        gc.gridx = 2;
        gc.gridy = 0;
        this.add(this.scrollPane, gc);
        JButton cancelButton = new JButton("Cancel");
        gc.gridx = 3;
        gc.gridy = 0;
        this.add(cancelButton, gc);
        cancelButton.addActionListener(e -> doCancel());

        updateList();
    }

    @Override
    public void update(Observable o, Object arg) {
        updateList();
    }

    protected void updateList(){
        viewInScroll.removeAll();
        model.getTwits().forEach(twit -> {
            TwitComponent twitComponent = new TwitComponent(twit);
            viewInScroll.add(twitComponent);
        });
        this.scrollPane.getViewport().repaint();
        revalidate();
        repaint();
    }

    protected void doCancel(){
        listeners.forEach(ICancelListener::notifyCancel);
    }

}
