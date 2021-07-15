package com.isunican.eventossantander.view.events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.isunican.eventossantander.R;
import com.isunican.eventossantander.model.Event;
import com.isunican.eventossantander.presenter.events.EventsPresenter;

import java.util.List;

public class EventsActivity extends AppCompatActivity implements IEventsView {

    private IEventsPresenter presenter;
    private EventArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new EventsPresenter(this);
    }


    @Override
    public void onEventsLoaded(List<Event> events) {
        adapter = new EventArrayAdapter(EventsActivity.this, 0, events);
        ListView listView = findViewById(R.id.eventsListView);
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoadError() {

    }

    @Override
    public void onLoadSuccess() {

    }

    @Override
    public void openEventDetails(Event event) {

    }
}