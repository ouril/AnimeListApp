package ru.gruzdev.common.network.api

import io.reactivex.Observable
import retrofit2.http.GET
import ru.gruzdev.common.network.data.AnimeFilm

/**
 * https://ghibliapi.herokuapp.com/
 */

interface AnimeApiService {

    @GET("films/")
    fun getAnimeFilms(): Observable<List<AnimeFilm>>
}