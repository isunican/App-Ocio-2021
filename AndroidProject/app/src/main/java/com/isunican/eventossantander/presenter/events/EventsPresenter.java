package com.isunican.eventossantander.presenter.events;

import com.isunican.eventossantander.model.Event;
import com.isunican.eventossantander.model.EventsRepository;
import com.isunican.eventossantander.view.Listener;
import com.isunican.eventossantander.view.events.IEventsContract;

import java.util.List;

public class EventsPresenter implements IEventsContract.Presenter {

    private final IEventsContract.View view;

    public EventsPresenter(IEventsContract.View view) {
        this.view = view;
        loadData();
    }

    private void loadData() {
        EventsRepository.getEvents(new Listener<List<Event>>() {
            @Override
            public void onSuccess(List<Event> data) {
                view.onEventsLoaded(data);
                view.onLoadSuccess();
            }

            @Override
            public void onFailure() {
                view.onLoadError();
            }
        });
    }

    @Override
    public void onEventClicked(Event event) {

    }

    @Override
    public void onReloadClicked() {
        loadData();
    }
}
