
package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public  class MainActivity extends AppCompatActivity {
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.CV);
        button2 = findViewById(R.id.bank);


    }


    public void OnClick(View v ) {
        Intent intent = new Intent(MainActivity.this, viewpage.class);
        startActivity(intent);

    }

}





