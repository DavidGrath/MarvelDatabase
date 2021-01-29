package com.example.marveldatabase.framework

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.example.marveldatabase.domain.entities.ui.MarvelUIEntity

class TempService : Service() {

    val binder = TempBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    class TempBinder : Binder() {
        var entity: MarvelUIEntity? = null
    }
}
