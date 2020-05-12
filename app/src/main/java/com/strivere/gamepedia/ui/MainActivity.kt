package com.strivere.gamepedia.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ImageViewCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.strivere.gamepedia.R
import com.strivere.gamepedia.ui.menudetail.ViewPagerAdapter
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.recyclerview_menu.*


class MainActivity : AppCompatActivity() {

    lateinit var image: CircleImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setSupportActionBar(findViewById(R.id.toolbar))
//
//        image = findViewById(R.id.icon_profile)
//        image.setOnClickListener {
//            Toast.makeText(this, "profile clicked", Toast.LENGTH_LONG).show()
//
//        }

    }


}
