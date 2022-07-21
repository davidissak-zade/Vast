// package com.example.vastandroid;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.eskillsandroid.fragments.DiscussionsFragment;
//import com.example.eskillsandroid.fragments.HomeFragment;
//import com.example.eskillsandroid.fragments.SearchFragment;
//
// public class MainActivity extends AppCompatActivity {
//     private Button button;
//
//     @Override
//     protected void onCreate(Bundle savedinstanceState){
//         super.onCreate(savedinstanceState);
//         setContentView(R.layout.activity_main);
//
//         button = (Button)findViewById(R.id.button);
//         button.setOnClickListener(new View.OnClickListener)(){
//             @Override
//             public void onClick(View v){
//                 openviewpage();
//             });
//     }




//    }
//}

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