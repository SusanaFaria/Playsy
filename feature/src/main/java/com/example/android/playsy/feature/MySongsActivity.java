package com.example.android.playsy.feature;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MySongsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        //create an array of songs

        final ArrayList<Songs> songs = new ArrayList<Songs>();
        songs.add(new Songs("We are the Champions", "Queen"));
        songs.add(new Songs("You can call me Al", "Paul Simon"));
        songs.add(new Songs("Let it be", "The Beatles"));
        songs.add(new Songs("Can't stop the feeling", "Justin Timberlake"));
        songs.add(new Songs("I'm yours", "Jason M'raz"));
        songs.add(new Songs("Happy", "Pharrell Williams"));
        songs.add(new Songs("Tive razão", "Seu Jorge"));
        songs.add(new Songs("Wave", "Tom Jobim"));
        songs.add(new Songs("Lazy song", "Bruno Mars"));
        songs.add(new Songs("Sugar", "Maroon5 "));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        final SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.songList);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                Songs currentlyClickedSong = (Songs)adapterView.getItemAtPosition(position);
                Intent mySongsIntent = new Intent(MySongsActivity.this, SongNowPlaying.class);
                mySongsIntent.putExtra("songs", (Parcelable) currentlyClickedSong);
                startActivity(mySongsIntent);
            }
        });
    }

}










