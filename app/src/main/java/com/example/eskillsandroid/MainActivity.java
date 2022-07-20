 package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.eskillsandroid.fragments.DiscussionsFragment;
import com.example.eskillsandroid.fragments.HomeFragment;
import com.example.eskillsandroid.fragments.SearchFragment;

 public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}