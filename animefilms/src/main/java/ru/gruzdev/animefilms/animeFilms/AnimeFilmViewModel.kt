package ru.gruzdev.animefilms.animeFilms

import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.gruzdev.common.base.BaseViewModel
import ru.gruzdev.common.network.data.AnimeFilm
import ru.gruzdev.common.network.repository.AnimeFilmsRepository

class AnimeFilmViewModel(val repository: AnimeFilmsRepository) : BaseViewModel() {

    private val data: MutableLiveData<List<AnimeFilm>> = MutableLiveData()

    fun observeDate(owner: LifecycleOwner, observer: Observer<List<AnimeFilm>>) {
        data.observe(owner, observer)
    }

    fun fetchData() {
        addDisposable(
            repository.getAnimeFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { films ->
                    println("-------------------------> ${films[0].id}")
                    data.postValue(films)
                })
    }

}