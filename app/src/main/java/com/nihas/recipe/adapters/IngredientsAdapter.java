package com.nihas.recipe.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nihas.recipe.R;
import com.nihas.recipe.activities.SelectIngredientsActivity;
import com.nihas.recipe.pojos.AllPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snyxius on 10/14/2015.
 */
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {

    private List<String> mDataset;
//    private ImageFetcher mImageFetcher;
    Activity activity;
    private static int colorCode=0;
    static int[] colorArray={R.color.color1,R.color.color2, R.color.color3,R.color.color4,
            R.color.color5,R.color.color6,R.color.color7,R.color.color8};

    public IngredientsAdapter(Activity activity, ArrayList<String> ingredients) {
        mDataset = ingredients;
        this.activity=activity;
//        this.mImageFetcher=mImageFetcher;

    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mIngredient,mTitleLetter;
        ImageView mColorView;
        public ViewHolder(View v) {
            super(v);
            mIngredient=(TextView)v.findViewById(R.id.ingredientTitle);
            mTitleLetter=(TextView)v.findViewById(R.id.titleLetter);
            mColorView=(ImageView)v.findViewById(R.id.maskImage);


//            mTextView = v;
        }
    }





    // Create new views (invoked by the layout manager)
//    @Override
    public IngredientsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {


        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredients_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);


        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mIngredient.setText(mDataset.get(position));
//        mImageFetcher.loadImage(mDataset.get(position).getUrl(), holder.mRimageView);
        holder.mTitleLetter.setText(mDataset.get(position).substring(0,1));

        if(colorCode<7) {
           colorCode++;
        }
        else colorCode=0;
        holder.mColorView.setBackgroundColor(activity.getResources().getColor(colorArray[colorCode]));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}