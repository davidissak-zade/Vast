package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class cvView extends AppCompatActivity {

    private YouTubePlayerView youtubeplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_view);

        youtubeplayer = findViewById(R.id.activity_cvView_youtubePlayerView);
        getLifecycle().addObserver(youtubeplayer);

        ImageButton BackButton = (ImageButton) findViewById(R.id.arrowbutton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cvView.this, MainActivity.class));
            }});


    }
}