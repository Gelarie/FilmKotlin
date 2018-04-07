package com.example.kinoversionlast

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlin.coroutines.experimental.CoroutineContext

fun savePhotos(
        app: App,
        photos: List<Film>,
        coroutineContext: CoroutineContext = CommonPool
): Deferred<Unit> = async(coroutineContext) {
    app.database.filmsDao().insertAll(photos)
}