package com.delight.labs.games

import androidx.multidex.MultiDexApplication
import com.delight.labs.games.di.appModule
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

/**
 * 页面描述：App
 *
 * Created by ditclear on 2018/12/11.
 */
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModule, logger = AndroidLogger(showDebug = BuildConfig.DEBUG))
    }
}