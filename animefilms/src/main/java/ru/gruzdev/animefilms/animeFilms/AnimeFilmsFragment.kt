package ru.gruzdev.animefilms.animeFilms

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_anime_films.*
import ru.gruzdev.animefilms.R
import ru.gruzdev.animefilms.animeFilms.paging.AnimeFilmsPaggingAdapter


import javax.inject.Inject
import ru.gruzdev.common.di.CommonApplication
import ru.gruzdev.animefilms.di.AnimeFilmComponent
import ru.gruzdev.animefilms.di.DaggerAnimeFilmComponent
import ru.gruzdev.common.base.BaseActivity
import ru.gruzdev.common.di.CommonComponent


class AnimeFilmsFragment : androidx.fragment.app.Fragment() {
    @Inject
    lateinit var viewModel: AnimeFilmViewModel
    lateinit var animeFilmsComponent: AnimeFilmComponent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inject()
        return inflater.inflate(R.layout.fragment_anime_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterAnime = AnimeFilmsPaggingAdapter()
        val viewManager = LinearLayoutManager(this.activity)
        anime_film_list.apply {
            setHasFixedSize(true)
            adapter = adapterAnime
            layoutManager = viewManager
        }
        viewModel.observeDate(this, Observer {
            adapterAnime.submitList(it)


        })

//        viewModel.fetchData()

    }

    fun inject() {
        val application = activity!!.application as CommonApplication
        animeFilmsComponent = DaggerAnimeFilmComponent
            .builder()
            .commonComponent(application.component())
            .root(activity as BaseActivity)
            .build()

        animeFilmsComponent.inject(this)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            AnimeFilmsFragment().apply {
            }
    }
}
