package com.trongdeptrai.recyclerviewmvvmsample.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trongdeptrai.recyclerviewmvvmsample.data.repository.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(
    private val repository: MoviesRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(
            repository
        ) as T
    }
}