package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    ImageButton searchButton, HomeButton, DiscussionsButton, BankAccount, Renting, License, CV, scholarship
     ,visa;
    private String PageID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"1", "ENG", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        searchButton = findViewById(R.id.searchbutton);
        DiscussionsButton = findViewById(R.id.DiscussionsButton);
        HomeButton = findViewById(R.id.HomeButton);
        BankAccount = findViewById(R.id.bankaccount);
        Renting = findViewById(R.id.renting);
        License = findViewById(R.id.license);
        CV = findViewById(R.id.CV);
        scholarship  = findViewById(R.id.scholarship );
        visa  = findViewById(R.id.visa );


        DiscussionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, MemberCommunityActivity.class));
            }
        });

        HomeButton.setOnClickListener(new View.OnClickListener(){
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

        Renting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);
                PageID = "1";
                i.putExtra("PageID", PageID);
                startActivity(i);
            }
        });


        BankAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);
                PageID = "3";
                i.putExtra("PageID", PageID);
                startActivity(i);
            }
        });


        License.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "2";
                i.putExtra("PageID", PageID);
                startActivity(i);
            }
        });

        CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "4";
                i.putExtra("PageID", PageID);
                startActivity(i);
            }
        });

        scholarship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "5";
                i.putExtra("PageID", PageID);
                startActivity(i);
            }
        });

        visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "6";
                i.putExtra("PageID", PageID);
                startActivity(i);
            }
        });

    }
}