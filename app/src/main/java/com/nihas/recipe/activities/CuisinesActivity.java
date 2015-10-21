package com.nihas.recipe.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nihas.recipe.R;
import com.nihas.recipe.adapters.CuisinesAdapter;
import com.nihas.recipe.pojos.AllPojo;

import java.util.ArrayList;

/**
 * Created by snyxius on 10/16/2015.
 */
public class CuisinesActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<AllPojo> listCuisines;
//    private ImageFetcher mImageFetcher;
//    private int mImageThumbSize=100;
//    private static final String IMAGE_CACHE_DIR = "thumbs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisines);
//        ImageCache.ImageCacheParams cacheParams =
//                new ImageCache.ImageCacheParams(this, IMAGE_CACHE_DIR);
//
//        cacheParams.setMemCacheSizePercent(0.25f); // Set memory cache to 25% of app memory
//
//        // The ImageFetcher takes care of loading images into our ImageView children asynchronously
//        mImageFetcher = new ImageFetcher(this, mImageThumbSize);
//        mImageFetcher.setLoadingImage(R.drawable.empty_photo);
//        mImageFetcher.addImageCache(getSupportFragmentManager(), cacheParams);


        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        CuisinesAdapter mAdapter = new CuisinesAdapter(getApplicationContext(),getCuisines());
        mRecyclerView.setAdapter(mAdapter);
    }

    public ArrayList<AllPojo> getCuisines(){
        listCuisines=new ArrayList<>();
        listCuisines.add(new AllPojo("ITALIAN","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","2 Recipes"));
        listCuisines.add(new AllPojo("INDIAN","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("FRENCH","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("MEXICAN","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("THAI","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("SPANISH","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("CHINESE","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("PIZZA","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("SEA FOOD","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        listCuisines.add(new AllPojo("AMERICAN","https://lh3.googleusercontent.com/-Tt9oNXXrAzo/ViYJSNptqLI/AAAAAAAAAoU/P3rVzaRPIPM/s240-Ic42/italy.png","5 Recipes"));
        return listCuisines;


    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//        mImageFetcher.setExitTasksEarly(false);
////        mAdapter.notifyDataSetChanged();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        mImageFetcher.setPauseWork(false);
//        mImageFetcher.setExitTasksEarly(true);
//        mImageFetcher.flushCache();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mImageFetcher.closeCache();
//    }
}
