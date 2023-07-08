package com.example.bookshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bookshop.fragment.HomeFragment
import com.example.bookshop.models.CartItem
import com.example.bookshop.models.Movie
import kotlinx.android.synthetic.main.activity_detail.btnAddtoCart

class DetailActivity : AppCompatActivity() {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra<Movie>(HomeFragment.INTENT_PARCELABLE)

        val imgSrc = findViewById<ImageView>(R.id.movie_photo)
        val imTitle = findViewById<TextView>(R.id.movie_name)
        val imRelease = findViewById<TextView>(R.id.movie_releasedata)

        if(movie != null){
            Glide.with(this).load(IMAGE_BASE + movie.poster_path).into(imgSrc)
            imTitle.text = movie.title
            imRelease.text = movie.release_date
        }

        btnAddtoCart.setOnClickListener {
            val item = CartItem(movie?.title.toString(), movie?.poster_path.toString())
            val shoppingCartManager = ShoppingCartManager(this)
            shoppingCartManager.addToCart(item)
        }
    }
}