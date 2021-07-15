package com.isunican.eventossantander.view.events;

import com.isunican.eventossantander.model.Event;

import java.util.List;

public interface IEventsView {

    void onEventsLoaded(List<Event> events);

    void onLoadError();

    void onLoadSuccess();

    void openEventDetails(Event event);

}
