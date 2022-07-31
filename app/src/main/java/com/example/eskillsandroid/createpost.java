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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Set;

public class createpost extends AppCompatActivity {

private Calendar calendar;
private SimpleDateFormat dateFormat;
public String Id, toId, sender, topic, txt, time, reputation;

    public String GetTime(){   // this function will take the time once it was called. we will call this function when a comment is added and set comment.time to the return value of this func
    calendar = Calendar.getInstance();
    dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    String date = dateFormat.format(calendar.getTime());
    return date;
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
                FirebaseDatabase DB = FirebaseDatabase.getInstance("https://vast-a293d-default-rtdb.firebaseio.com/");
                DatabaseReference ref = DB.getReference("comments");
                ref.setValue("sio");

                Id = SetID();   // sets random id that consists of 4 digits
                toId = "main";  // whenever id is main the comment is shown in the main community page
                sender = usernameInput.getText().toString();
                topic = topicInput.getText().toString();
                txt = contentInput.getText().toString();
                time = GetTime();
                comment CurrentComment = new comment(Id, toId, sender, topic, txt, time, 0);

                ref.setValue(CurrentComment);

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