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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.lang.reflect.Type;
import java.util.List;
import java.util.jar.Attributes;

import kotlinx.coroutines.channels.ProduceKt;



public class cvView extends AppCompatActivity {
    ImageButton BackButton;
    TextView LessonName;
    Button chat;
    private YouTubePlayerView youtubeplayer;
    public String PageID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://vast-a293d-default-rtdb.firebaseio.com/");
        DatabaseReference ref = database.getReference("pages");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            PageID = extras.getString("PageID");
            //The key argument here must match that used in the other activity
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_view);

        BackButton = findViewById(R.id.arrowbutton);
        LessonName = findViewById(R.id.TopicName);

        TextView TopicName, Introduction, VideoRecap, recaptitle1, c1text1, recaptitle2, c2text1;
        TopicName = findViewById(R.id.TopicName);
        Introduction = findViewById(R.id.intro);
        VideoRecap = findViewById(R.id.VideoRecap);
        recaptitle1 = findViewById(R.id.recaptitle1);
        recaptitle2 = findViewById(R.id.recaptitle2);
        c1text1 = findViewById(R.id.c1text1);
        c2text1 = findViewById(R.id.c2text1);
        chat = findViewById(R.id.chat);




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
                Log.d("DB", "Page ID: " + PageId);
                Log.d("DB", "Page Intro: " + PageIntro);
                Log.d("DB", "Page Name: " + PageName);
                Log.d("DB", "Page Steps Names: " + PageStepsNames);
                Log.d("DB", "Page Steps: " + PageSteps);
                Log.d("DB", "Page ID: " + VideoLink);

                TopicName.setText(PageName + " ");
                Introduction.setText(PageIntro);
                c1text1.setText(PageSteps);

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