package com.example.slidingnavigationdrawer

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toggle=object :ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open,R.string.close){
            val scaleFactor=6f
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Log.d("Draw","Offset: "+slideOffset)
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = drawerView.width * slideOffset
                content.translationX = slideX
//                content.scaleX = 1 - slideOffset / scaleFactor
                content.scaleY = 1 - slideOffset / scaleFactor
                if (slideOffset > 0f) {
                   DrawableCompat.setTint(resources.getDrawable(R.drawable.rounded),Color.BLUE)
                    content.setBackgroundResource(R.drawable.rounded)
                } else {
                    content.setBackgroundColor(resources.getColor(R.color.colorAccent))
                }
            }
        }
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setDrawerElevation(0f);
        drawerLayout.addDrawerListener(toggle)
        openmenu.setOnClickListener{
            drawerLayout.openDrawer(Gravity.LEFT)
        }
    }
}
