package com.example.android.playsy.feature;

import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView mySongs = findViewById(R.id.mySongs);
        EditText search = findViewById(R.id.search);
        final ImageView youTube = findViewById(R.id.youTube);
        ImageView googlePlay = findViewById(R.id.googlePlay);

        // Set a click listener on My Songs View with an intent to start a new activity with the Songs list
        mySongs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent mySongsIntent = new Intent(MainActivity.this, MySongsActivity.class);
                startActivity(mySongsIntent);
            }
        });

        //Set a click listener on YouTube ImgView with an intent to open youtube app or url
        youTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.youTube.com";

                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);

                }
            }
        });

        //Set a click listener on GooglePlayMusic ImgView with an intent to open the app or the url
        googlePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://play.google.com/music"));
                startActivity(intent);

            }

        });

        //Note: TODO: implement search feature

    }


}
