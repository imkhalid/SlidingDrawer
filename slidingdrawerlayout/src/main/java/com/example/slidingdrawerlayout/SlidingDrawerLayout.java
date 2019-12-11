package com.example.slidingdrawerlayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

public class SlidingDrawerLayout {
    public SlidingDrawerLayout(Activity activity, DrawerLayout mDrawerLayout, final View v){
        ActionBarDrawerToggle mActionbarToggle=new ActionBarDrawerToggle(activity,mDrawerLayout,R.string.open,R.string.close){
            private float scaleFactor=6f;
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
}
