package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



public class MainActivity extends AppCompatActivity {

    ImageButton searchButton, HomeButton, DiscussionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.searchbutton);
        DiscussionsButton = findViewById(R.id.DiscussionsButton);
        HomeButton = findViewById(R.id.HomeButton);


        DiscussionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, MemberCommunityActivity.class));
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchBarActivity.class));
            }
        });

        ImageButton CV = (ImageButton) findViewById(R.id.CV);
        CV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, cvView.class));
            }
        });
    }
}