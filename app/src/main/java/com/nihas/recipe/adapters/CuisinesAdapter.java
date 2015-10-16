package com.nihas.recipe.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nihas.recipe.R;
import com.nihas.recipe.customui.RecyclingImageView;
import com.nihas.recipe.customui.SquareImageView;
import com.nihas.recipe.pojos.AllPojo;
import com.nihas.recipe.util.ImageFetcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snyxius on 10/14/2015.
 */
public class CuisinesAdapter extends RecyclerView.Adapter<CuisinesAdapter.ViewHolder> {

    private List<AllPojo> mDataset;
    private ImageFetcher mImageFetcher;
    Activity activity;

    public CuisinesAdapter(Activity activity, ArrayList<AllPojo> ingredients, ImageFetcher mImageFetcher) {
        mDataset = ingredients;
        this.activity=activity;
        this.mImageFetcher=mImageFetcher;

    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Title,SubTitle;
        RecyclingImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            Title=(TextView)v.findViewById(R.id.cuisineTitle);
            SubTitle=(TextView)v.findViewById(R.id.cuisineSubTitle);
            mImageView=(RecyclingImageView)v.findViewById(R.id.img_thumbnail);

        }
    }





    // Create new views (invoked by the layout manager)
//    @Override
    public CuisinesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {


        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cuisine_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.Title.setText(mDataset.get(position).getTitle());
        mImageFetcher.loadImage(mDataset.get(position).getUrl(), holder.mImageView);
        holder.SubTitle.setText(mDataset.get(position).getSubTitle());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}