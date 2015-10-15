package com.nihas.recipe.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.nihas.recipe.R;
import com.nihas.recipe.adapters.MyAdapter;
import com.nihas.recipe.app.RecipeApp;
import com.nihas.recipe.extra.Keys;
import com.nihas.recipe.pojos.AllPojo;
import com.nihas.recipe.recipeapi.WebRequest;
import com.nihas.recipe.recipeapi.WebServices;
import com.nihas.recipe.util.ImageCache;
import com.nihas.recipe.util.ImageFetcher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snyxius on 10/14/2015.
 */
public class HomeFragment extends Fragment implements Keys.RecipeAllKey{

    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<AllPojo> homeItems;
    ProgressBar progressBar;
    private int mImageThumbSize=100;
    private int mImageThumbSpacing=1;
    private ImageFetcher mImageFetcher;
    private static final String IMAGE_CACHE_DIR = "thumbs";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageCache.ImageCacheParams cacheParams =
                new ImageCache.ImageCacheParams(getActivity(), IMAGE_CACHE_DIR);

        cacheParams.setMemCacheSizePercent(0.25f); // Set memory cache to 25% of app memory

        // The ImageFetcher takes care of loading images into our ImageView children asynchronously
        mImageFetcher = new ImageFetcher(getActivity(), mImageThumbSize);
        mImageFetcher.setLoadingImage(R.drawable.empty_photo);
        mImageFetcher.addImageCache(getActivity().getSupportFragmentManager(), cacheParams);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        initialize(view);




        homeItems=new ArrayList<>();

        if (RecipeApp.isNetworkAvailable())


            new GetRecipes().execute(WebServices.getRecipe("onions", "omelet", 1));


        else{
            Fragment newFragment = new ConnectionErrorFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack("HOME");

            transaction.commit();
        }



    }

    private void initialize(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
    }

    private class GetRecipes extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            onDone(s);
        }
        @Override
        protected String doInBackground(String... params) {
            return WebRequest.getData(params[0]);
        }
    }


    private void onDone(String s){
        progressBar.setVisibility(View.GONE);

        try {
            homeItems = new ArrayList<>();
            JSONObject jobj = new JSONObject(s);
            if(jobj.has(results)) {

                JSONArray jsonArray = jobj.getJSONArray(results);
                if (jsonArray.length() == 0) {

                } else {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        homeItems.add(new AllPojo(obj.getString(title),obj.getString(thumbnail)));
//                        allPojo.setId(obj.getString(id));
//                        allPojo.setEvent_name(obj.getString(event_name));
//                        allPojo.setEvent_location(obj.getString(event_location));
//                        allPojo.setEvent_address(obj.getString(event_address));
//                        allPojo.setPhoto(obj.getString(photo));
//                        allPojo.setAvg_price(obj.getString(avg_price));
//                        allPojo.setTimings(obj.getString(timings));
//                        arrayEvents.add(allPojo);
                    }
                }

                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(getActivity(),homeItems,mImageFetcher);
                mRecyclerView.setAdapter(mAdapter);
//                mRecyclerList.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
//                    @Override
//                    public void onLoadMore(int current_page) {
//
//                        if (GymchaloApp.isNetworkAvailable())
//
//                            if(GymchaloApp.readFromPreferences(getActivity(),searchframe, SyncStateContract.Constants.DEFAULTINT) == SyncStateContract.Constants.MIDDLE){
//                                new ScrollGetFitnessClasses().execute(WebServices.upcomingfetchListings(SyncStateContract.Constants.CITY,
//                                        GymchaloApp.readFromPreferences(getActivity(),keyword,Constants.DEFAULTSTRING),Constants.LIMIT,Constants.LIMIT * current_page + Constants.INITIAL));
//                            }else {
//                                new ScrollGetFitnessClasses().execute(WebServices.upcomingfetchListings(Constants.CITY, Constants.LIMIT,Constants.LIMIT * current_page + Constants.INITIAL));
//                            }
//                        else{
//
//                            Fragment newFragment = new ConnectionErrorFragment();
//                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                            transaction.replace(R.id.container, newFragment);
//                            transaction.addToBackStack(Constants.EVENT);
//
//                            transaction.commit();
//                        }
//
//
//                    }
//
//
//
//                });


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onResume() {
        super.onResume();
        mImageFetcher.setExitTasksEarly(false);
//        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        mImageFetcher.setPauseWork(false);
        mImageFetcher.setExitTasksEarly(true);
        mImageFetcher.flushCache();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mImageFetcher.closeCache();
    }


}
