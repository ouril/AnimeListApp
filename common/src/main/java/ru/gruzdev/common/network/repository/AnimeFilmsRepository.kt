package ru.gruzdev.common.network.repository

import io.reactivex.Observable
import ru.gruzdev.common.network.api.AnimeApiService
import ru.gruzdev.common.network.data.AnimeFilm

class AnimeFilmsRepository(val animeApi: AnimeApiService) {

    fun getAnimeFilms(): Observable<List<AnimeFilm>> = animeApi.getAnimeFilms()
}