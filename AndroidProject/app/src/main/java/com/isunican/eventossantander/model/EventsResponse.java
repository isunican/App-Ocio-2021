package com.isunican.eventossantander.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventsResponse {

    @SerializedName(value="resources")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
