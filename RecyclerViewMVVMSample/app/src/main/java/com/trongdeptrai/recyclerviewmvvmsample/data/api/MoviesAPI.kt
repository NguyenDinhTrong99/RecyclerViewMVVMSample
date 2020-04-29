package com.trongdeptrai.recyclerviewmvvmsample.data.api

import com.trongdeptrai.recyclerviewmvvmsample.data.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesAPI {

    @GET("movies.php")
    suspend fun getMovies(): Response<List<Movie>>

    companion object{
        operator fun invoke(): MoviesAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.85.4.97/mvvm/")
                .build()
                .create(MoviesAPI::class.java)
        }
    }
}