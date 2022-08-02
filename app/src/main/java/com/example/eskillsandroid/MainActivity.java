package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;



public class MainActivity extends AppCompatActivity {

    ImageButton searchButton, HomeButton, DiscussionsButton, BankAccount, Renting, License;
    private String PageID;
    private Object AdapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner mySpinner = findViewById(R.id.spinner1);
        String[] items = new String[]{"ENG", "ARB", "HEB"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int i, long id) {
                if (i == 0){
                    mySpinner.setOnItemSelectedListener(this);

                }else
                    if(i == 1) {
                        startActivity(new Intent(MainActivity.this, arabicActivity.class));
               }else
                   if(i ==2){
                       startActivity(new Intent(MainActivity.this, hebrewActivity.class));

                   }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {

            }
        });





        searchButton = findViewById(R.id.searchbutton);
        DiscussionsButton = findViewById(R.id.DiscussionsButton);
        HomeButton = findViewById(R.id.HomeButton);
        BankAccount = findViewById(R.id.bankaccount);
        Renting = findViewById(R.id.renting);
        License = findViewById(R.id.license);


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


    }
}