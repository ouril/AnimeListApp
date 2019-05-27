package ru.gruzdev.animefilms.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import ru.gruzdev.animefilms.animeFilms.AnimeFilmViewModel
import ru.gruzdev.common.base.BaseActivity
import ru.gruzdev.common.network.repository.AnimeFilmsRepository
import androidx.lifecycle.ViewModel
import ru.gruzdev.animefilms.animeFilms.paging.AnimeFilmsDataSource


@Module
class AnimeFilmsModules {
    @Provides
    @AnimeFilmsScope
    fun provideViewModel(host: BaseActivity, repository: AnimeFilmsRepository): AnimeFilmViewModel {
        return ViewModelProviders.of(host, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(AnimeFilmsRepository::class.java).newInstance(repository)
            }
        }).get(AnimeFilmViewModel::class.java)
    }


    @Provides
    @AnimeFilmsScope
    fun provideDataSource(repository: AnimeFilmsRepository): AnimeFilmsDataSource {
        return AnimeFilmsDataSource(repository)
    }
}