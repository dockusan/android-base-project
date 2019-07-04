package com.an.dagger.ui.adapter

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import com.an.dagger.data.local.entity.MovieEntity
import com.an.dagger.databinding.MoviesListItemBinding
import com.squareup.picasso.Picasso
import com.an.dagger.R


class MoviesListAdapter(private val activity: Activity) : androidx.recyclerview.widget.RecyclerView.Adapter<MoviesListAdapter.CustomViewHolder>() {
    private var movies: MutableList<MovieEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListAdapter.CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = MoviesListItemBinding.inflate(layoutInflater, parent, false)
        return CustomViewHolder(itemBinding)
    }

    fun setItems(movies: List<MovieEntity>) {
        val startPosition = this.movies.size
        this.movies.addAll(movies)
        notifyItemRangeChanged(startPosition, movies.size)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun getItem(position: Int): MovieEntity {
        return movies[position]
    }

    override fun onBindViewHolder(holder: MoviesListAdapter.CustomViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    inner class CustomViewHolder(private val binding: MoviesListItemBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        init {

            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            val width = displayMetrics.widthPixels

            itemView.layoutParams = androidx.recyclerview.widget.RecyclerView.LayoutParams(
                (width * 0.85f).toInt(),
                androidx.recyclerview.widget.RecyclerView.LayoutParams.WRAP_CONTENT
            )
        }

        fun bindTo(movie: MovieEntity) {
            Picasso.get().load(movie.getFormattedPosterPath())
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.image)
        }
    }
}
