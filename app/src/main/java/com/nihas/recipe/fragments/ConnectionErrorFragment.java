package com.nihas.recipe.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nihas.recipe.R;
import com.nihas.recipe.app.RecipeApp;


/**
 * Created by snyxius on 10/5/2015.
 */
public class ConnectionErrorFragment extends Fragment implements  View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.connection_error_layout,container,false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

    private void initialize(View view){
        view.findViewById(R.id.retryButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.retryButton:
            if(RecipeApp.isNetworkAvailable()) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                getActivity().getSupportFragmentManager().popBackStack();
            }else{
                getActivity().onBackPressed();
            }

            break;

        }

    }
}
