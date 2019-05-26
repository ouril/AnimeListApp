package ru.gruzdev.animefilms.di

import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import ru.gruzdev.animefilms.animeFilms.AnimeFilmsFragment
import ru.gruzdev.common.base.BaseActivity
import ru.gruzdev.common.di.CommonComponent

@AnimeFilmsScope
@Component(dependencies = [CommonComponent::class], modules = [AnimeFilmsModules::class])
interface AnimeFilmComponent {
    //@Provides
    fun inject(fragment: AnimeFilmsFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun root(root: BaseActivity): Builder

        fun commonComponent(commonComponent: CommonComponent): Builder

        fun build(): AnimeFilmComponent
    }
}