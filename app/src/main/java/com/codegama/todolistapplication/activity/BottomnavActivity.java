package com.codegama.todolistapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.codegama.todolistapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomnavActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnav);

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, new HomeFragment()).commit();

       bnv=(BottomNavigationView)findViewById(R.id.bottomnavigationview);
       bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment temp=null;
               switch(item.getItemId()){
                   case R.id.nav_home: temp=new HomeFragment();
                   break;

                   case R.id.nav_progress: temp=new ProgressFragment();
                   break;

                   case R.id.nav_profile:temp=new ProfileFragment();
                   break;
               }

               getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer, temp).commit();


               return true;
           }
       });

    }
}