package ru.gruzdev.common.base

import io.reactivex.disposables.Disposable
import io.reactivex.disposables.CompositeDisposable
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
