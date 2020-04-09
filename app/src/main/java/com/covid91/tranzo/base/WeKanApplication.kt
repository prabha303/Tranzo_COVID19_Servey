package com.covid91.tranzo.base

import android.content.Context
import com.covid91.tranzo.base.service.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class WeKanApplication() : DaggerApplication(){

    init {
        instance = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
     }
    companion object {
        private var instance: WeKanApplication? = null
        fun getApplicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }



}