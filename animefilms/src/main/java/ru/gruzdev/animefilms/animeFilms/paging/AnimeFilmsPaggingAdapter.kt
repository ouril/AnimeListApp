package ru.gruzdev.animefilms.animeFilms.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import ru.gruzdev.animefilms.animeFilms.Holder
import ru.gruzdev.animefilms.databinding.AnimeFilmItemBinding
import ru.gruzdev.common.network.data.AnimeFilm

class AnimeFilmsPaggingAdapter() : PagedListAdapter<AnimeFilm, Holder>(
     object : ItemCallback<AnimeFilm>() {
        override fun areItemsTheSame(oldItem: AnimeFilm, newItem: AnimeFilm): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: AnimeFilm, newItem: AnimeFilm): Boolean = oldItem.id == newItem.id
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AnimeFilmItemBinding.inflate(inflater, parent, false)
        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.film = getItem(position)
//        holder.binding.film = items[position]
    }
}