package com.example.bookshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.bookshop.fragment.HomeFragment
import com.example.bookshop.models.Movie

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra<Movie>(HomeFragment.INTENT_PARCELABLE)

        val imgSrc = findViewById<ImageView>(R.id.movie_photo)
        val imTitle = findViewById<TextView>(R.id.movie_name)
        val imRelease = findViewById<TextView>(R.id.movie_releasedata)

        if(movie != null){
            imTitle.setText(movie.title)
            imRelease.setText(movie.release_date)
        }
    }
}