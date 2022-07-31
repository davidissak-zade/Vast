package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MemberCommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_community);

//        Button HomeButton = (Button) findViewById(R.id.HomeButton);  // link to the home page
//        HomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MemberCommunityActivity.this, MainActivity3.class));
//            }
//        });
//
//        Button SearchButton = (Button) findViewById(R.id.SearchButton); // link to the search page
//        SearchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MemberCommunityActivity.this, SearchBarActivity.class));
//            }
//        });

        ImageButton BackButton = (ImageButton) findViewById(R.id.MemberCommunityBackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberCommunityActivity.this, MainActivity.class));
            }
        });

        ImageButton CreatePostButton = (ImageButton) findViewById(R.id.createPostButton);
        CreatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberCommunityActivity.this, createpost.class));
            }
        });

        ImageButton CommentButton1 = (ImageButton) findViewById(R.id.CommentButton1);
        CreatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberCommunityActivity.this, replyPost.class));
            }
        });


    }
}