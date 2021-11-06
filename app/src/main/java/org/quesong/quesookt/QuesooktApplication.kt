package org.quesong.quesookt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.quesong.quesookt.util.PixelRatio

@HiltAndroidApp
class QuesooktApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        pixelRatio = PixelRatio(this)
    }

    companion object {
        lateinit var pixelRatio: PixelRatio
    }
}