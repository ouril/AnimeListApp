package ru.gruzdev.common.di

import ru.gruzdev.common.network.repository.AnimeFilmsRepository

interface CommonComponent {
    fun animeFilmsRepository(): AnimeFilmsRepository
}