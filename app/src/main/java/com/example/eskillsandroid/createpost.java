package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class createpost extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpost);
        ImageButton BackButton = (ImageButton) findViewById(R.id.arrowbutton);
        TextInputEditText usernameInput = (TextInputEditText) findViewById(R.id.username);
        TextInputEditText topicInput = findViewById(R.id.post);
        TextInputEditText contentInput = findViewById(R.id.mind);
        ImageButton SearchButton = findViewById(R.id.SearchButton);
        ImageButton HomeButton = findViewById(R.id.HomeButton);
        ImageButton DiscussionsButton = findViewById(R.id.DiscussionsButton);


        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createpost.this, MemberCommunityActivity.class));
            }
        });

        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createpost.this, SearchBarActivity.class));
            }
        });

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createpost.this, MainActivity.class));
            }
        });


        DiscussionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createpost.this, MemberCommunityActivity.class));
            }
        });

        ImageButton SubmitButton = (ImageButton) findViewById(R.id.sendbutton);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // for Adding comments to firebase -> code here



                //All of the code under this line is for opening an alert window
                AlertDialog.Builder builder = new AlertDialog.Builder(createpost.this);
                builder.setCancelable(true);
                builder.setTitle("Thank you!");
                builder.setMessage("Your comment was added to the database!");  //hahah no, but we are working on it

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();

                //erase textholders values
                usernameInput.setText("");
                topicInput.setText("");
                contentInput.setText("");
            }
        });
    }
}