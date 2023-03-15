package com.example.bookshop.services

import com.example.bookshop.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface{
    @GET("/3/movie/popular?api_key=c6ec046981d220c8430997cfd9c00f8c")
    fun getMovieList(): Call<MovieResponse>
}