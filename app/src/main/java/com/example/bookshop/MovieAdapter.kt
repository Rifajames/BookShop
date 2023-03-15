package com.example.bookshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookshop.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (
    private val movies : List<Movie>,
    val listener : (Movie) -> Unit
    //listener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: Movie, listener: (Movie) -> Unit){
            itemView.movie_title.text = movie.title
            itemView.movie_release.text = movie.release_date
            Glide.with(itemView).load(IMAGE_BASE + movie.poster_path).into(itemView.movie_poster)
            itemView.setOnClickListener{listener(movie)}
            //itemview.setonclicklistener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position),listener)
    }

    override fun getItemCount(): Int = movies.size
}