package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ImageButton searchButton, HomeButton, DiscussionsButton, BankAccount, Renting, License, CV, scholarship
     ,visa;
    TextView cvtxt,scholtxt,interviewtxt, examtxt,unitxt, banktxt,visatxt, savingtxt,loantxt, billtxt, taxestxt,licensetxt, renttxt, insuracetxt, cartxt,mailtxt,laundrytxt;
    private String PageID;
    private String Language = "ENG";
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
                Log.d("INDENT", ""+i);
                if (i == 0){
                    mySpinner.setOnItemSelectedListener(this);

                }else
                    if(i == 1) {
                        Language = "ARB";

                }else
                   if(i ==2){
                       Language = "HEB";

                   }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {

            }
        });




        cvtxt = findViewById(R.id.cvtxt);
        scholtxt = findViewById(R.id.scholtxt);
        interviewtxt = findViewById(R.id.interviewtxt);
        examtxt= findViewById(R.id.examtxt);
        unitxt= findViewById(R.id.unitxt);
        banktxt = findViewById(R.id.banktxt);
        visatxt= findViewById(R.id.visatxt);
        savingtxt= findViewById(R.id.savingtxt);
        loantxt = findViewById(R.id.loantxt);
        billtxt = findViewById(R.id.billtxt);
        taxestxt = findViewById(R.id.taxestxt);
        licensetxt = findViewById(R.id.licensetxt);
        renttxt = findViewById(R.id.renttxt);
        insuracetxt = findViewById(R.id.insuracetxt);
        cartxt = findViewById(R.id.cartxt);
        mailtxt = findViewById(R.id.mailtxt);
        laundrytxt = findViewById(R.id.laundrytxt);

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