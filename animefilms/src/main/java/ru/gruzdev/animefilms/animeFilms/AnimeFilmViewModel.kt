package ru.gruzdev.animefilms.animeFilms

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.gruzdev.animefilms.animeFilms.paging.AnimeFilmDataSourceFactory
import ru.gruzdev.common.base.BaseViewModel
import ru.gruzdev.common.network.data.AnimeFilm
import ru.gruzdev.common.network.repository.AnimeFilmsRepository

class AnimeFilmViewModel(val repository: AnimeFilmsRepository) : BaseViewModel() {
    private var data: LiveData<PagedList<AnimeFilm>>

    init {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(5)
            .build()
        data = LivePagedListBuilder<Int, AnimeFilm>(
            AnimeFilmDataSourceFactory(
                repository
            ), config).build()
    }

//    private val dataMuteble: MutableLiveData<List<AnimeFilm>> = MutableLiveData()


    fun observeDate(owner: LifecycleOwner, observer: Observer<PagedList<AnimeFilm>>) {
        data.observe(owner, observer)
    }

//    fun fetchData() {
//        addDisposable(
//            repository.getAnimeFilms()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { films ->
//                    dataMuteble.postValue(films)
//                })
//    }

}