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
public class RecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AllPojo> mDataset;
//    private ImageFetcher mImageFetcher;
    private Context context;
    Activity activity;
    ImageLoader imageLoader;
    DisplayImageOptions options;
    private LayoutInflater inflater;
    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;


    public RecipeAdapter(Context context, ArrayList<AllPojo> ingredients) {
        mDataset = ingredients;
        this.context=context;
        inflater = LayoutInflater.from(this.context);
//        this.mImageFetcher=mImageFetcher;
        imageLoader = ImageLoader.getInstance();

    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ItemHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Title,SubTitle;
        ImageView mImageView;
        public ItemHolder(View v) {
            super(v);
            Title=(TextView)v.findViewById(R.id.cuisineTitle);
            SubTitle=(TextView)v.findViewById(R.id.cuisineSubTitle);
            mImageView=(ImageView)v.findViewById(R.id.img_thumbnail);

        }
    }


   class HeaderHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Title,SubTitle;
        ImageView mImageView;
        public HeaderHolder(View v) {
            super(v);

        }
    }





    // Create new views (invoked by the layout manager)
//    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {


        // set the view's size, margins, paddings and layout parameters
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
//        options = new DisplayImageOptions.Builder().cacheInMemory(true)
//                .cacheOnDisc(true).resetViewBeforeLoading(true)
//                .showImageForEmptyUri(R.drawable.empty_photo)
//                .showImageOnFail(R.drawable.empty_photo)
//                .showImageOnLoading(R.drawable.empty_photo).build();

        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.empty_photo)
                .showImageOnFail(R.drawable.empty_photo)
                .showImageOnLoading(R.drawable.empty_photo).build();

        if(viewType==TYPE_HEADER) {
            // create a new view
            View v = inflater
                    .inflate(R.layout.profile_header_view, parent, false);
            HeaderHolder vh = new HeaderHolder(v);
            return vh;
        }else{
            View v = inflater
                    .inflate(R.layout.recipe_item, parent, false);
            ItemHolder vh = new ItemHolder(v);
            return vh;
        }

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderHolder ){

        }else {
            ItemHolder itemHolder= (ItemHolder) holder;
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            itemHolder.Title.setText(mDataset.get(position).getTitle());
//        mImageFetcher.loadImage(mDataset.get(position).getUrl(), holder.mImageView);
            imageLoader.displayImage(mDataset.get(position).getUrl(), itemHolder.mImageView, options);
            itemHolder.SubTitle.setText(mDataset.get(position).getSubTitle());
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }else{
            return TYPE_ITEM;
        }
    }

    }