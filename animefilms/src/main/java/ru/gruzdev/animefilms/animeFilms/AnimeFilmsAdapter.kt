package ru.gruzdev.animefilms.animeFilms

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import ru.gruzdev.animefilms.databinding.AnimeFilmItemBinding
import ru.gruzdev.common.network.data.AnimeFilm

class AnimeFilmsAdapter(val items: List<AnimeFilm>): androidx.recyclerview.widget.RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AnimeFilmItemBinding.inflate(inflater, parent, false)
        return Holder(binding.root)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.film = items[position]
    }
}