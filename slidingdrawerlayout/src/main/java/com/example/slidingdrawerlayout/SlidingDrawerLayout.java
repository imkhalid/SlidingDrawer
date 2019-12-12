package com.example.slidingdrawerlayout;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class SlidingDrawerLayout {
    private float scaleFactor=6f;
    private Activity activity;
    public SlidingDrawerLayout(Activity activity, DrawerLayout mDrawerLayout, final View v){
        ActionBarDrawerToggle mActionbarToggle=new ActionBarDrawerToggle(activity,mDrawerLayout,R.string.open,R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                float slideX=drawerView.getWidth()*slideOffset;
                v.setTranslationX(slideX);
                v.setScaleX(1- (slideOffset / scaleFactor));
                v.setScaleY(1- (slideOffset / scaleFactor));
            }
        };
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerElevation(0f);
        mDrawerLayout.addDrawerListener(mActionbarToggle);
    }

    public SlidingDrawerLayout(Activity activity, final DrawerLayout mDrawerLayout, final View v, View toggleBtn){
        //with toggle button
        ActionBarDrawerToggle mActionbarToggle=new ActionBarDrawerToggle(activity,mDrawerLayout,R.string.open,R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                float slideX=drawerView.getWidth()*slideOffset;
                v.setTranslationX(slideX);
                v.setScaleX(1- (slideOffset / scaleFactor));
                v.setScaleY(1- (slideOffset / scaleFactor));
            }
        };
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerElevation(0f);
        mDrawerLayout.addDrawerListener(mActionbarToggle);
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    public SlidingDrawerLayout(Activity mActivity, DrawerLayout mDrawerLayout, final View container, float mScaleFactor, final int containerColor){
        /*
        this function has Drawable with rounded container and custom color
        */
        if (mScaleFactor!=0f)
            scaleFactor=mScaleFactor;

        this.activity=mActivity;
        ActionBarDrawerToggle mActionbarToggle=new ActionBarDrawerToggle(activity,mDrawerLayout,R.string.open,R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                float slideX=drawerView.getWidth()*slideOffset;
                container.setTranslationX(slideX);
                container.setScaleX(1- (slideOffset / scaleFactor));
                container.setScaleY(1- (slideOffset / scaleFactor));
                if (slideOffset>0f) {
                    Drawable unwrappedDrawable = AppCompatResources.getDrawable(activity, R.drawable.rounded);
                    Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
                    DrawableCompat.setTint(wrappedDrawable, containerColor);
                    container.setBackgroundResource(R.drawable.rounded);
                }
                else {
                    container.setBackgroundColor(containerColor);
                }
            }
        };
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerElevation(0f);
        mDrawerLayout.addDrawerListener(mActionbarToggle);
    }

    public SlidingDrawerLayout(Activity mActivity, final DrawerLayout mDrawerLayout,
                               final View container, View toggleBtn, float mScaleFactor, final int containerColor){

        /*
        this function has Drawable with rounded container, custom color and toggle btn
        */
        if (mScaleFactor!=0f)
            scaleFactor=mScaleFactor;

        this.activity=mActivity;
        ActionBarDrawerToggle mActionbarToggle=new ActionBarDrawerToggle(activity,mDrawerLayout,R.string.open,R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                float slideX=drawerView.getWidth()*slideOffset;
                container.setTranslationX(slideX);
                container.setScaleX(1- (slideOffset / scaleFactor));
                container.setScaleY(1- (slideOffset / scaleFactor));
                if (slideOffset>0f) {
                    DrawableCompat.setTint(activity.getResources().getDrawable(R.drawable.rounded),containerColor);
                    container.setBackgroundResource(R.drawable.rounded);
                }
                else {
                    container.setBackgroundColor(containerColor);
                }
            }
        };
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerElevation(0f);
        mDrawerLayout.addDrawerListener(mActionbarToggle);
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }


}
