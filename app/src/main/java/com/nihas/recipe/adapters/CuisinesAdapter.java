package com.nihas.recipe.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nihas.recipe.R;
import com.nihas.recipe.customui.GradientoverImageDrawable;
import com.nihas.recipe.customui.SquareImageView;
import com.nihas.recipe.pojos.AllPojo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snyxius on 10/14/2015.
 */
public class CuisinesAdapter extends RecyclerView.Adapter<CuisinesAdapter.ViewHolder> {

    private List<AllPojo> mDataset;
//    private ImageFetcher mImageFetcher;
    private Context context;
    Activity activity;
    ImageLoader imageLoader;
    DisplayImageOptions options;
    private LayoutInflater inflater;


    public CuisinesAdapter(Context context, ArrayList<AllPojo> ingredients) {
        mDataset = ingredients;
        this.context=context;
        inflater = LayoutInflater.from(this.context);
//        this.mImageFetcher=mImageFetcher;
        imageLoader = ImageLoader.getInstance();

    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Title,SubTitle;
        ImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            Title=(TextView)v.findViewById(R.id.cuisineTitle);
            SubTitle=(TextView)v.findViewById(R.id.cuisineSubTitle);
            mImageView=(ImageView)v.findViewById(R.id.img_thumbnail);

        }
    }





    // Create new views (invoked by the layout manager)
//    @Override
    public CuisinesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {


        // create a new view
        View v = inflater
                .inflate(R.layout.cuisine_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        // set the view's size, margins, paddings and layout parameters
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
//        options = new DisplayImageOptions.Builder().cacheInMemory(true)
//                .cacheOnDisc(true).resetViewBeforeLoading(true)
//                .showImageForEmptyUri(R.drawable.empty_photo)
//                .showImageOnFail(R.drawable.empty_photo)
//                .showImageOnLoading(R.drawable.empty_photo).build();

        options = new DisplayImageOptions.Builder().cacheInMemory(true).displayer(new BitmapDisplayer() {
            @Override
            public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
                int gradientStartColor = Color.parseColor("#55000000");//argb(0, 0, 0, 0);
                int gradientEndColor = Color.parseColor("#55000000");//argb(255, 0, 0, 0);
                GradientoverImageDrawable gradientDrawable = new GradientoverImageDrawable(context.getResources(), bitmap);
                gradientDrawable.setGradientColors(gradientStartColor, gradientEndColor);
                imageAware.setImageDrawable(gradientDrawable);
            }
        })
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.empty_photo)
                .showImageOnFail(R.drawable.empty_photo)
                .showImageOnLoading(R.drawable.empty_photo).build();


        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.Title.setText(mDataset.get(position).getTitle());
//        mImageFetcher.loadImage(mDataset.get(position).getUrl(), holder.mImageView);
        imageLoader.displayImage(mDataset.get(position).getUrl(), holder.mImageView, options);
        holder.SubTitle.setText(mDataset.get(position).getSubTitle());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}