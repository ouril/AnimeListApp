package ru.gruzdev.animefilms.animeFilms.paging

import androidx.paging.DataSource
import ru.gruzdev.animefilms.animeFilms.paging.AnimeFilmsDataSource
import ru.gruzdev.common.network.data.AnimeFilm
import ru.gruzdev.common.network.repository.AnimeFilmsRepository

class AnimeFilmDataSourceFactory(val repository: AnimeFilmsRepository): DataSource.Factory<Int, AnimeFilm> (){
    override fun create(): DataSource<Int, AnimeFilm> {
        return AnimeFilmsDataSource(repository)
    }
}