package com.isunican.eventossantander.view.events;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.isunican.eventossantander.R;
import com.isunican.eventossantander.model.Event;

import java.util.List;

public class EventArrayAdapter extends ArrayAdapter<Event> {

    private final List<Event> events;

    public EventArrayAdapter(@NonNull Context context, int resource, @NonNull List<Event> objects) {
        super(context, resource, objects);
        this.events = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Event event = events.get(position);

        // Create item view
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.events_listview_item, null);

        // Link subviews
        TextView title = view.findViewById(R.id.item_event_title);

        // Assign values to subviews
        title.setText(event.getNombre());

        return view;
    }
}
