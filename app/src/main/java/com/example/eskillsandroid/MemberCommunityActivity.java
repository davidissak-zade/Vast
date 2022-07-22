package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemberCommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_community);

        Button HomeButton = (Button) findViewById(R.id.HomeButton);  // link to the home page
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberCommunityActivity.this, MainActivity3.class));
            }
        });

        Button SearchButton = (Button) findViewById(R.id.SearchButton); // link to the search page
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberCommunityActivity.this, SearchBarActivity.class));
            }
        });

    }
}