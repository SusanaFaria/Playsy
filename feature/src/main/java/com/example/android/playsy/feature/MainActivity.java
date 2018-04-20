package com.example.android.playsy.feature;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    TextView mySongs = findViewById(R.id.mySongs);
    TextView search = findViewById(R.id.search);
    ImageView youTube = findViewById(R.id.youTube);
    ImageView googlePlay = findViewById(R. id. googlePlay);

        // Set a click listener on My Songs View
        mySongs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent mySongsIntent = new Intent(MainActivity.this, MySongsActivity.class);
                startActivity(mySongsIntent);
            }
        });



    }
}
