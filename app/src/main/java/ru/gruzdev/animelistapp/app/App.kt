package ru.gruzdev.animelistapp.app

import android.app.Application
import ru.gruzdev.animelistapp.di.ApplicationComponent
import ru.gruzdev.animelistapp.di.DaggerApplicationComponent
import ru.gruzdev.common.di.CommonApplication
import ru.gruzdev.common.di.CommonComponent

class App: Application(), CommonApplication {
    override fun component(): CommonComponent = applicationComponent

    override fun onCreate() {
        super.onCreate()
        makeComponent()
    }

    fun makeComponent(){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }
    companion object {
        @JvmStatic
        lateinit var applicationComponent: ApplicationComponent

    }
}