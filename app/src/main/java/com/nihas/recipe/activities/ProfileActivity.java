package com.nihas.recipe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.nihas.recipe.R;
import com.nihas.recipe.adapters.CuisinesAdapter;
import com.nihas.recipe.adapters.RecipeAdapter;
import com.nihas.recipe.pojos.AllPojo;

import java.util.ArrayList;

/**
 * Created by snyxius on 10/21/2015.
 */
public class ProfileActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList<AllPojo> listCuisines;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecipeAdapter mAdapter = new RecipeAdapter(getApplicationContext(),getCuisines());
        mRecyclerView.setAdapter(mAdapter);
    }

    public ArrayList<AllPojo> getCuisines(){
        listCuisines=new ArrayList<>();
        listCuisines.add(new AllPojo("ITALIAN", "https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png", "2 Recipes"));
        listCuisines.add(new AllPojo("INDIAN","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("FRENCH", "https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png", "5 Recipes"));
        listCuisines.add(new AllPojo("MEXICAN","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("THAI","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("SPANISH","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("CHINESE","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("PIZZA","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("SEA FOOD", "https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png", "5 Recipes"));
        listCuisines.add(new AllPojo("AMERICAN", "https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png", "5 Recipes"));
        return listCuisines;


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }else if(id==R.id.action_search){

            Intent searchIntent=new Intent(ProfileActivity.this,CuisinesActivity.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.push_up_in,R.anim.fade_out);

        }

        return super.onOptionsItemSelected(item);
    }
}
