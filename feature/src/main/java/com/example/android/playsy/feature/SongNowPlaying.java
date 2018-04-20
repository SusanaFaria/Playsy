package com.example.android.playsy.feature;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongNowPlaying extends MySongsActivity {

    private Songs songView;
    private TextView myView;
    private TextView myView1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_now_playing);

       myView = (TextView) findViewById(R.id.song);
       myView1 = (TextView)findViewById(R.id.artist);


       Intent senderIntent = getIntent();
        if (senderIntent.hasExtra("song")) {

           songView = senderIntent.getParcelableExtra("song");


            myView.setText(songView.getSongName());
            myView1.setText(songView.getPerformer());

        }

    }
}




