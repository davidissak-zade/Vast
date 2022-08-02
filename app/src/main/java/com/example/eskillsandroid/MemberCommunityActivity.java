package com.example.eskillsandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MemberCommunityActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Adapter ThisAdapter;
    ArrayList<comment> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_community);

        recyclerView = findViewById(R.id.CommentsList);
        database = FirebaseDatabase.getInstance("https://vast-a293d-default-rtdb.firebaseio.com/").getReference("comments");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        ThisAdapter = new Adapter(this, list);
        recyclerView.setAdapter(ThisAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    comment CurrentComment = dataSnapshot.getValue(comment.class);
                    Log.d("COMMENT", CurrentComment.toString());
                    list.add(CurrentComment);

                }
                ThisAdapter.notifyDataSetChanged();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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


    }
}