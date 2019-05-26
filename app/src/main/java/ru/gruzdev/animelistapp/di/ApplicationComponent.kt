package ru.gruzdev.animelistapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.gruzdev.animelistapp.di.modules.ApplicationModule
import ru.gruzdev.common.di.CommonComponent
import javax.inject.Singleton
import  ru.gruzdev.common.di.modules.*


@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent: CommonComponent {
    @Component.Builder
    interface  Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}