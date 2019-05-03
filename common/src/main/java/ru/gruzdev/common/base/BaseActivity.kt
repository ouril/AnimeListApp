package ru.gruzdev.common.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    fun pushFragment(fragment: Fragment){
        if(!supportFragmentManager.popBackStackImmediate(fragment.javaClass.simpleName, 0)){
            supportFragmentManager.beginTransaction()
                .addToBackStack(fragment.javaClass.simpleName)
                .replace(containerResId(), fragment)
        }
    }

    protected fun containerResId(): Int {
        return 0
    }

    fun removeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
    }

    fun removePreviousFragment(fragmentName: String) {
        val fragments = supportFragmentManager.fragments
        for (i in fragments.indices) {
            val fragment = fragments[i]
            if (fragment.javaClass.simpleName != fragmentName) {
                removeFragment(fragment as Fragment)
                break
            }
        }
    }


}