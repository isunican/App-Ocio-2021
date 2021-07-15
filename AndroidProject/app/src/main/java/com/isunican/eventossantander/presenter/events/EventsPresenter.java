package com.isunican.eventossantander.presenter.events;

import com.isunican.eventossantander.model.Event;
import com.isunican.eventossantander.model.EventsAPI;
import com.isunican.eventossantander.model.EventsResponse;
import com.isunican.eventossantander.model.EventsService;
import com.isunican.eventossantander.view.events.IEventsPresenter;
import com.isunican.eventossantander.view.events.IEventsView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsPresenter implements IEventsPresenter {

    private final IEventsView view;

    public EventsPresenter(IEventsView view) {
        this.view = view;
        loadData();
    }

    private void loadData() {
        EventsAPI eventosService = EventsService.getEventsServiceInstance();
        Call<EventsResponse> callEvents = eventosService.getEventosResponse();

        callEvents.enqueue(new Callback<EventsResponse>() {
            @Override
            public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {
                EventsResponse body = response.body();
                if (body != null) {
                    view.onEventsLoaded(body.getEvents());
                    view.onLoadSuccess();
                }
            }

            @Override
            public void onFailure(Call<EventsResponse> call, Throwable t) {
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
