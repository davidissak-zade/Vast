package com.example.eskillsandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class cvView extends AppCompatActivity {
    ImageButton BackButton;
    TextView LessonName;
    private YouTubePlayerView youtubeplayer;
    public int PageID;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_view);
        BackButton = findViewById(R.id.arrowbutton);
        LessonName = findViewById(R.id.TopicName);


        youtubeplayer = findViewById(R.id.activity_cvView_youtubePlayerView);
        getLifecycle().addObserver(youtubeplayer);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String value = extras.getString("PageID");
            Log.d("ourTag", value);


        }

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cvView.this, MainActivity.class));
            }});



    }
}