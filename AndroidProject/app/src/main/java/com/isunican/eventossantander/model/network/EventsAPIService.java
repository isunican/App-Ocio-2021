package com.isunican.eventossantander.model.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventsAPIService {

    private static EventsAPI eventosService;

    public static EventsAPI getEventsServiceInstance() {
        if (eventosService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://datos.santander.es/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            eventosService = retrofit.create(EventsAPI.class);
        }
        return eventosService;
    }
}
