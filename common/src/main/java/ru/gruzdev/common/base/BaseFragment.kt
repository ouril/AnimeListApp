package ru.gruzdev.common.base

import android.app.PendingIntent.getActivity
import android.view.ViewGroup
import android.view.LayoutInflater
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View


abstract class BaseFragment : androidx.fragment.app.Fragment() {

    val root: BaseActivity
        get() = activity as BaseActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inject()
        return inflate(inflater, container!!)
    }

    protected open fun inject() {}

    protected abstract fun inflate(inflater: LayoutInflater, container: ViewGroup): View
}
