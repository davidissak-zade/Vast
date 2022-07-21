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

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

<<<<<<< Updated upstream
import com.example.eskillsandroid.fragments.DiscussionsFragment;
import com.example.eskillsandroid.fragments.HomeFragment;
import com.example.eskillsandroid.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {
=======
 public class MainActivity extends AppCompatActivity {
>>>>>>> Stashed changes
    private Button button;
    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< Updated upstream
        button = findViewById(R.id.button1);

=======
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openviewpage();
            }
        });
    }

     private void openviewpage() {
     }

     public void  opennviewpage(){
        Intent intent = new Intent(this, viewpage.class);
        startActivity(intent);
>>>>>>> Stashed changes
    }
    public void Onclick(View view){
        Intent intent = new Intent (this, viewpage.class);
        startActivity(intent);
    }
}




