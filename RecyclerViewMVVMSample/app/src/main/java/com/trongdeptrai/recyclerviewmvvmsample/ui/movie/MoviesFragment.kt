package com.trongdeptrai.recyclerviewmvvmsample.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.trongdeptrai.recyclerviewmvvmsample.data.api.MoviesAPI
import com.trongdeptrai.recyclerviewmvvmsample.data.repository.MoviesRepository
import com.trongdeptrai.recyclerviewmvvmsample.R
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment() {
    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesAPI()
        val repository = MoviesRepository(api)
        factory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer {
            movies -> recyclerViewMovies.also {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter =
                MoviesAdapter(
                    movies = movies
                )
        }
        })
    }
}
