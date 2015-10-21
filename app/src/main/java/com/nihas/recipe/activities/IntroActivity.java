package com.nihas.recipe.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nihas.recipe.R;
import com.nihas.recipe.util.CirclePageIndicator;

/**
 * Created by snyxius on 10/15/2015.
 */
public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        viewPager.setAdapter(new ViewPagerAdapter(R.array.icons, R.array.titles, R.array.hints));



        CirclePageIndicator mIndicator  = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
            case R.id.signup:
                Intent nextIntent=new Intent(IntroActivity.this,ProfileActivity.class);
                startActivity(nextIntent);
                finish();
                break;
        }
    }


    public class ViewPagerAdapter extends PagerAdapter {

        private int iconResId, titleArrayResId, hintArrayResId;

        public ViewPagerAdapter(int iconResId, int titleArrayResId, int hintArrayResId) {

            this.iconResId = iconResId;
            this.titleArrayResId = titleArrayResId;
            this.hintArrayResId = hintArrayResId;
        }

        @Override
        public int getCount() {
            return getResources().getIntArray(iconResId).length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Drawable icon = getResources().obtainTypedArray(iconResId).getDrawable(position);
            String title = getResources().getStringArray(titleArrayResId)[position];
            String hint = getResources().getStringArray(hintArrayResId)[position];


            View itemView = getLayoutInflater().inflate(R.layout.viewpager_item, container, false);


            ImageView iconView = (ImageView) itemView.findViewById(R.id.landing_img_slide);
            TextView titleView = (TextView)itemView.findViewById(R.id.landing_txt_title);
            TextView hintView = (TextView)itemView.findViewById(R.id.landing_txt_hint);


            iconView.setImageDrawable(icon);
            titleView.setText(title);
            hintView.setText(hint);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);

        }
    }
}
