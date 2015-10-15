package com.nihas.recipe.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nihas.recipe.R;
import com.nihas.recipe.adapters.IngredientsAdapter;

import java.util.ArrayList;

/**
 * Created by snyxius on 10/15/2015.
 */
public class SelectIngredientsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<String> listIngredients;
    IngredientsAdapter ingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_ingredients);

        mRecyclerView=(RecyclerView)findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ingAdapter=new IngredientsAdapter(this,getIngredients());
        mRecyclerView.setAdapter(ingAdapter);


    }

    public ArrayList<String> getIngredients(){
        listIngredients=new ArrayList<>();
        listIngredients.add("Banana");
        listIngredients.add("Apple");
        listIngredients.add("Onion");
        listIngredients.add("Ginger");
        listIngredients.add("Garlic");
        listIngredients.add("Tamarind");
        listIngredients.add("Cucumber");
        listIngredients.add("Tomato");
        listIngredients.add("Chilly");
        listIngredients.add("Chicken");
        listIngredients.add("Brinjal");
        listIngredients.add("Elephant Yam");
        return listIngredients;


    }
}
