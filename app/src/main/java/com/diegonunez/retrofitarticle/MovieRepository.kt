package com.diegonunez.retrofitarticle

import com.diegonunez.retrofitarticle.ui.theme.TmdbApi

class MovieRepository(private val api : TmdbApi) : BaseRepository() {
    suspend fun getPopularMovies() : MutableList<TmdbMovie>?{
        val movieResponse = safeApiCall(
            call = {api.getPopularMovie().await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.results?.toMutableList();
    }
}