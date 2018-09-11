package org.hm.com.imageslider.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class SliderApp : Application()
{
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}