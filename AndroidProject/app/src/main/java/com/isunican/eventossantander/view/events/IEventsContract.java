package com.isunican.eventossantander.view.events;

import com.isunican.eventossantander.model.Event;

import java.util.List;

public interface IEventsContract {

    public interface Presenter {

        void onEventClicked(Event event);

        void onReloadClicked();

    }

    public interface View {

        void onEventsLoaded(List<Event> events);

        void onLoadError();

        void onLoadSuccess();

        void openEventDetails(Event event);

    }
}
