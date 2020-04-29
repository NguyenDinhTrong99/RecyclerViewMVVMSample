package com.trongdeptrai.recyclerviewmvvmsample.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.trongdeptrai.recyclerviewmvvmsample.data.model.Movie
import com.trongdeptrai.recyclerviewmvvmsample.R
import com.trongdeptrai.recyclerviewmvvmsample.databinding.RecyclerviewMovieBinding

class MoviesAdapter(
    private  val movies: List<Movie>
): RecyclerView.Adapter<MoviesAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
             DataBindingUtil.inflate(
                 LayoutInflater.from(parent.context),
                 R.layout.recyclerview_movie,
                 parent, false
             )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.recyclerviewMovieBinding.item = movies[position]
    }

    inner class VH(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ): RecyclerView.ViewHolder(recyclerviewMovieBinding.root) {

    }
}