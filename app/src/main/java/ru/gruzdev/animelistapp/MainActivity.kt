package ru.gruzdev.animelistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.gruzdev.animefilms.animeFilms.AnimeFilmsFragment
import ru.gruzdev.common.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pushFragment(AnimeFilmsFragment.newInstance())
    }

    override fun containerResId(): Int {
        return R.id.container
    }

}
