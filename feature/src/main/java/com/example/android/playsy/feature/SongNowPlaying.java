package com.example.android.playsy.feature;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongNowPlaying extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_now_playing);

        //find the texts Views
        TextView myView = (TextView) findViewById(R.id.song);
        TextView myView1 = (TextView) findViewById(R.id.artist);

        //get the intent from My songs activity
        Intent mySongsIntent = getIntent();
        //extract the parcelable extra

        Songs songView = mySongsIntent.getParcelableExtra("songs");
        if (mySongsIntent.hasExtra("songs")) {

            String song = songView.getSongName();
            String art = songView.getPerformer();

            //set text on the extracted strings


            myView.setText(song);
            myView1.setText(art);

        }
        //implement a back navigation button
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpFromSameTask(SongNowPlaying.this);
            }
        });
    }
}







