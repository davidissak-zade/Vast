package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        Button HomeButton = (Button) findViewById(R.id.HomeButton);  // link to the home page
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchBarActivity.this, MainActivity.class));
            }
        });

        Button DiscussionsButton = (Button) findViewById(R.id.DiscussionsButton);   // link to the discussions page
        DiscussionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(SearchBarActivity.this, MemberCommunityActivity.class));
            }
        });


    }
}