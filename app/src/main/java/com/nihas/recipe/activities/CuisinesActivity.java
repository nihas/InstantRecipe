package com.nihas.recipe.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nihas.recipe.R;
import com.nihas.recipe.adapters.CuisinesAdapter;
import com.nihas.recipe.pojos.AllPojo;
import com.nihas.recipe.util.ImageCache;
import com.nihas.recipe.util.ImageFetcher;

import java.util.ArrayList;

/**
 * Created by snyxius on 10/16/2015.
 */
public class CuisinesActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<AllPojo> listCuisines;
    private ImageFetcher mImageFetcher;
    private int mImageThumbSize=100;
    private static final String IMAGE_CACHE_DIR = "thumbs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_ingredients);
        ImageCache.ImageCacheParams cacheParams =
                new ImageCache.ImageCacheParams(this, IMAGE_CACHE_DIR);

        cacheParams.setMemCacheSizePercent(0.25f); // Set memory cache to 25% of app memory

        // The ImageFetcher takes care of loading images into our ImageView children asynchronously
        mImageFetcher = new ImageFetcher(this, mImageThumbSize);
        mImageFetcher.setLoadingImage(R.drawable.empty_photo);
        mImageFetcher.addImageCache(getSupportFragmentManager(), cacheParams);


        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        CuisinesAdapter mAdapter = new CuisinesAdapter(this,getCuisines(),mImageFetcher);
        mRecyclerView.setAdapter(mAdapter);
    }

    public ArrayList<AllPojo> getCuisines(){
        listCuisines=new ArrayList<>();
        listCuisines.add(new AllPojo("ITALIAN","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","2 Recipes"));
        listCuisines.add(new AllPojo("INDIAN","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        listCuisines.add(new AllPojo("FRENCH","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        listCuisines.add(new AllPojo("MEXICAN","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpgg","5 Recipes"));
        listCuisines.add(new AllPojo("THAI","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        listCuisines.add(new AllPojo("SPANISH","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        listCuisines.add(new AllPojo("CHINESE","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        listCuisines.add(new AllPojo("PIZZA","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        listCuisines.add(new AllPojo("SEA FOOD","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        listCuisines.add(new AllPojo("AMERICAN","http://www.foodjournaling.com/wp-content/uploads/2012/07/10-thai-food-cuisine-570x380.jpg","5 Recipes"));
        return listCuisines;


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
