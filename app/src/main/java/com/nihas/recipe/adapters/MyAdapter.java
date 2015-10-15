package com.nihas.recipe.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nihas.recipe.R;
import com.nihas.recipe.customui.RecyclingImageView;
import com.nihas.recipe.pojos.AllPojo;
import com.nihas.recipe.util.ImageFetcher;

import java.util.List;

/**
 * Created by snyxius on 10/14/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<AllPojo> mDataset;
    private ImageFetcher mImageFetcher;
    Activity activity;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        RecyclingImageView mRimageView;
        public ViewHolder(View v) {
            super(v);
            mTextView=(TextView)v.findViewById(R.id.info_text);
            mRimageView=(RecyclingImageView)v.findViewById(R.id.list_image);
//            mTextView = v;
        }
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Activity activity, List<AllPojo> myDataset, ImageFetcher mImageFetcher) {
        mDataset = myDataset;
        this.activity=activity;
        this.mImageFetcher=mImageFetcher;




    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {


        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getTitle());
        mImageFetcher.loadImage(mDataset.get(position).getUrl(), holder.mRimageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}