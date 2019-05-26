package ru.gruzdev.animefilms.animeFilms

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import ru.gruzdev.animefilms.databinding.AnimeFilmItemBinding


class Holder(val view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    val binding: AnimeFilmItemBinding  = DataBindingUtil.bind(view)!!

}