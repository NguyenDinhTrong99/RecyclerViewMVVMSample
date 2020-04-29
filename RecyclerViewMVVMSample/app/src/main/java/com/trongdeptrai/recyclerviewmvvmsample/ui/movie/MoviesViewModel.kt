package com.trongdeptrai.recyclerviewmvvmsample.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trongdeptrai.recyclerviewmvvmsample.data.model.Movie
import com.trongdeptrai.recyclerviewmvvmsample.data.repository.MoviesRepository
import com.trongdeptrai.recyclerviewmvvmsample.utils.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {
    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
