package com.example.android.playsy.feature;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        // Create an ArrayAdapter whose data source is a list of Strings. .

        final SongAdapter adapter = new SongAdapter(this, R.layout.activity_list_item, songs);

        // Find the ListView
        ListView listView = (ListView) findViewById(R.id.songList);

        // Make the ListView use the ArrayAdapter
        listView.setAdapter(adapter);


        //set On Item ClickListener on the List View with an intent to open a new activity
        // that displays the currently picked item (song, in this case) and passes the necessary data to the new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                Songs currentlyClickedSong = (Songs) adapter.getItem(position);
                Intent mySongsIntent = new Intent(MySongsActivity.this, SongNowPlaying.class);
                mySongsIntent.putExtra("songs", currentlyClickedSong);
                startActivity(mySongsIntent);
            }
        });

        adapter.notifyDataSetChanged();
    }
}
















