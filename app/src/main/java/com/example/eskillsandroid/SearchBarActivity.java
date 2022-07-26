package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase ;

public class SearchBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

            /*
        ImageButton HomeButton = (ImageButton) findViewById(R.id.HomeButton);  // link to the home page
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchBarActivity.this, MainActivity.class));
            }
        });

        ImageButton DiscussionsButton = (ImageButton) findViewById(R.id.DiscussionsButton);   // link to the discussions page
        DiscussionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(SearchBarActivity.this, MemberCommunityActivity.class));
            }
        });
*/
        ImageButton BackButton = findViewById(R.id.arrowbutton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchBarActivity.this, MainActivity.class));
            }
        });


    }
}