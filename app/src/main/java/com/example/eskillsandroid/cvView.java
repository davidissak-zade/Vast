package com.example.eskillsandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Arrays;


public class cvView extends AppCompatActivity {
    ImageButton BackButton;
    Button chat;
    private YouTubePlayerView youtubeplayer;
    public String PageID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        FirebaseDatabase database = FirebaseDatabase.getInstance("https://vast-a293d-default-rtdb.firebaseio.com/");
        DatabaseReference ref = database.getReference("pages");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {  // if there are extras
            PageID = extras.getString("PageID");
            Log.d("PAGEID", PageID);
            //The key argument here must match that used in the other activity
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_view); // load the xml page (~activity_view.xml)

        BackButton = findViewById(R.id.arrowbutton);

        TextView TopicName, Introduction, c1text1, c2text1, c3text1, c4text1;
        TopicName = findViewById(R.id.TopicName);
        Introduction = findViewById(R.id.intro);
        c1text1 = findViewById(R.id.c1text1);
        c2text1 = findViewById(R.id.c2text1);
        c3text1 = findViewById(R.id.c3text1);
        c4text1 = findViewById(R.id.c4text1);
        chat = findViewById(R.id.chat);

    // Find a child in the database with id of the passed PageID value
        ref.child(PageID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                page Page = snapshot.getValue(page.class);
                String PageId = Page.getId();
                String PageIntro = Page.getIntro();
                String PageName = Page.getName();
                String PageStepsNames = Page.getStepName();
                String PageSteps = Page.getSteps();
                String VideoLink = Page.getVideoLink();

                TopicName.setText(PageName + " ");

                String[] StepsNames, Steps;
                Steps = PageSteps.split("@");

                Introduction.setText(PageIntro);
                c1text1.setText(Steps[0]);
                c2text1.setText(Steps[1]);
                c3text1.setText(Steps[2]);
                c4text1.setText(Steps[3]);

                youtubeplayer = findViewById(R.id.activity_cvView_youtubePlayerView);
                getLifecycle().addObserver(youtubeplayer);

                youtubeplayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        super.onReady(youTubePlayer);
                        youTubePlayer.cueVideo(VideoLink,0);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });


        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cvView.this, MainActivity.class));
            }});


        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cvView.this, MemberCommunityActivity.class));
            }});


    }
}