package com.example.android.playsy.feature;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Songs> {


    public SongAdapter(Activity context, int activity_list_item, ArrayList<Songs> songs) {
        // Initialize the ArrayAdapter's internal storage for the context and the list.
        super(context, 0, songs);
    }

    /**
     * Provides a view for the ListView
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_item, parent, false);
        }

        // Get the Songs object located at this position in the list
        Songs currentSongs = getItem(position);

        // Find the Performer TextView in the activity_list_item.xml
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.performer);
        // set this text on the Performer TextView
        defaultTextView.setText(currentSongs.getPerformer());

        // Find the Song TextView in the activity_list_item.xml
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.songName);
        // set this text on the Song TextView
        numberTextView.setText(currentSongs.getSongName());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
