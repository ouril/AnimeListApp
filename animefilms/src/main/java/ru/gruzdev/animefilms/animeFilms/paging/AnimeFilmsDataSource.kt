package ru.gruzdev.animefilms.animeFilms.paging

import androidx.paging.PositionalDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.gruzdev.common.network.data.AnimeFilm
import ru.gruzdev.common.network.repository.AnimeFilmsRepository

class AnimeFilmsDataSource(val repository: AnimeFilmsRepository): PositionalDataSource<AnimeFilm>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<AnimeFilm>) {
        repository.getAnimeFilms().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            callback.onResult(it)
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<AnimeFilm>) {
        repository.getAnimeFilms().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            callback.onResult(it, params.requestedStartPosition)
        }
    }
}