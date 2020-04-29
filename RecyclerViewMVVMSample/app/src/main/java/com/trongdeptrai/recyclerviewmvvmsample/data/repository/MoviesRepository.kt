package com.trongdeptrai.recyclerviewmvvmsample.data.repository

import com.trongdeptrai.recyclerviewmvvmsample.data.api.MoviesAPI

class MoviesRepository(
    private val api: MoviesAPI
): SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}