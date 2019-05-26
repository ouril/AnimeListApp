package ru.gruzdev.common.di.modules

import dagger.Module
import dagger.Provides
import ru.gruzdev.common.network.api.AnimeApiService
import ru.gruzdev.common.network.repository.AnimeFilmsRepository


@Module
class RepositoryModule {

    @Provides
    fun provideAnimeFilmRepository(apiService: AnimeApiService):AnimeFilmsRepository =
            AnimeFilmsRepository(apiService)
}