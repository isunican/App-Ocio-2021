package com.isunican.eventossantander.view.events;

import com.isunican.eventossantander.model.Event;

public interface IEventsPresenter {

    void onEventClicked(Event event);

    void onReloadClicked();

}
