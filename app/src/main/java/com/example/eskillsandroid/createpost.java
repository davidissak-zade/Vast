package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;


public class createpost extends AppCompatActivity {

    FirebaseDatabase DB;
    DatabaseReference ref;

    public String Id, toName, sender, topic, txt, time, reputation;


public String GetTime(){   // this function will take the time once it was called. we will call this function when a comment is added and set comment.time to the return value of this func
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTXT = formatter.format(date);
        Log.d("TIME", dateTXT);
        return dateTXT;
    }

public String SetID(){   // this function will create a pseudo-unique id for each comment. an id is a combination of 4 random digits;
    Random random = new Random();
    String[] digits = {"1","2","3","4","5","6","7","8","9","0"};
    String output ="";
    output += digits[random.nextInt(10)]; // adding a digit with a random index inside the digits array
    output += digits[random.nextInt(10)]; //2nd digit
    output += digits[random.nextInt(10)]; //3rd digit
    output += digits[random.nextInt(10)]; //4th digit
    return output;
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpost);
        ImageButton BackButton = (ImageButton) findViewById(R.id.arrowbutton);

        DB = FirebaseDatabase.getInstance("https://vast-a293d-default-rtdb.firebaseio.com/");
        ref = DB.getReference("comments");

        TextInputEditText usernameInput = (TextInputEditText) findViewById(R.id.SenderName);
        TextInputEditText topicInput = findViewById(R.id.CommentTopic);
        TextInputEditText contentInput = findViewById(R.id.CommentContent);


        BackButton.setOnClickListener(new View.OnClickListener() {
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

                Id = SetID();   // sets random id that consists of 4 digits
                toName = "main";  // whenever id is main the comment is shown in the main community page
                sender = usernameInput.getText().toString();
                topic = topicInput.getText().toString();
                txt = contentInput.getText().toString();
                time = GetTime();
                comment CurrentComment = new comment(Id, toName, sender, topic, txt, time, 0L);

                if(TextUtils.isEmpty(usernameInput.getText().toString()) || TextUtils.isEmpty(topicInput.getText().toString()) || TextUtils.isEmpty(contentInput.getText().toString())){
                    // if any of the input fields were left empty, throw popup window and don't create comment instance
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(createpost.this);
                    builder2.setCancelable(true);
                    builder2.setTitle("Can't add empty post");
                    builder2.setMessage("You left some of the fields empty, please fill them and share!");

                    builder2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder2.show();
                }


                else {

                    ref.push().setValue(CurrentComment);  // add the instance of the current comment to the DB

                    //All of the code under this line is for opening an alert window

                    AlertDialog.Builder builder = new AlertDialog.Builder(createpost.this);
                    builder.setCancelable(true);
                    builder.setTitle("Thank you!");
                    builder.setMessage("Your comment was added to the database!");

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

            }
        });
    }
}