package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class arabicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);
//
//        Spinner mySpinner = findViewById(R.id.spinner1);
//        String[] items = new String[]{"ENG", "ARB", "HEB"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//        mySpinner.setAdapter(adapter);
//
//        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int i, long id) {
//                Log.d("INDENT", "" + i);
//                if (i == 0){
//                    startActivity(new Intent(arabicActivity.this, MainActivity.class));
//
//                }else
//                if(i == 1) {
//                    mySpinner.setOnItemSelectedListener(this);
//                }else
//                if(i ==2){
//                    startActivity(new Intent(arabicActivity.this, hebrewActivity.class));
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(android.widget.AdapterView<?> parent) {
//
//            }
//        });

    }

}