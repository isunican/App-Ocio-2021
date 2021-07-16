package com.isunican.eventossantander.model;

import com.isunican.eventossantander.model.network.EventsAPI;
import com.isunican.eventossantander.model.network.EventsAPIResponse;
import com.isunican.eventossantander.model.network.EventsAPIService;
import com.isunican.eventossantander.view.Listener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsRepository {

    public static void getEvents(Listener<List<Event>> listener) {
        EventsAPI eventosService = EventsAPIService.getEventsServiceInstance();
        Call<EventsAPIResponse> callEvents = eventosService.getEventosResponse();

        callEvents.enqueue(new Callback<EventsAPIResponse>() {
            @Override
            public void onResponse(Call<EventsAPIResponse> call, Response<EventsAPIResponse> response) {
                EventsAPIResponse body = response.body();
                if (body != null) {
                    listener.onSuccess(body.getEvents());
                }
            }

            @Override
            public void onFailure(Call<EventsAPIResponse> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

}
