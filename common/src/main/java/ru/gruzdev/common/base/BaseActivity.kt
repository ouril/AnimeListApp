package ru.gruzdev.common.base

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    fun pushFragment(fragment: androidx.fragment.app.Fragment){
        if(!supportFragmentManager.popBackStackImmediate(fragment.javaClass.simpleName, 0)){
            supportFragmentManager.beginTransaction()
                .addToBackStack(fragment.javaClass.simpleName)
                .replace(containerResId(), fragment).commit()
        }
    }

    open fun containerResId(): Int {
        return 0
    }

    fun removeFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
    }

    fun removePreviousFragment(fragmentName: String) {
        val fragments = supportFragmentManager.fragments
        for (i in fragments.indices) {
            val fragment = fragments[i]
            if (fragment.javaClass.simpleName != fragmentName) {
                removeFragment(fragment as androidx.fragment.app.Fragment)
                break
            }
        }
    }


}