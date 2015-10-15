package com.nihas.recipe.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nihas.recipe.R;
import com.nihas.recipe.fragments.HomeFragment;

/**
 * Created by snyxius on 10/14/2015.
 */
public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new HomeFragment(), "kj")
                .commit();


    }



}
