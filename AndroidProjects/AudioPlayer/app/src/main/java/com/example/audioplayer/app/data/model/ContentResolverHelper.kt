package com.example.audioplayer.app.data.model

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import androidx.annotation.WorkerThread
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ContentResolverHelper @Inject constructor(@ApplicationContext val context: Context) {
    private var mCursor: Cursor? = null
    private val projection: Array<String> = arrayOf(
        MediaStore.Audio.AudioColumns.DISPLAY_NAME,
        MediaStore.Audio.AudioColumns._ID,
        MediaStore.Audio.AudioColumns.ARTIST,
        MediaStore.Audio.AudioColumns.DATA,
        MediaStore.Audio.AudioColumns.DURATION,
        MediaStore.Audio.AudioColumns.TITLE,
    )
    private var selectionClause: String? = "${MediaStore.Audio.AudioColumns.IS_MUSIC}=?"
    private var selectionArq = arrayOf("1")
    private var sortOrder = "${MediaStore.Audio.AudioColumns.DISPLAY_NAME} ASC"

    @WorkerThread
    fun getAudioData(): List<MediaStore.Audio> {
    }

    private fun getCursorData(): MutableList<Audio> {
        val audioList = mutableListOf<Audio>()
        mCursor = context.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            selectionClause,
            selectionArq,
            sortOrder
        )
        mCursor?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.AudioColumns._ID
            )
            val displayNameColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.AudioColumns.DISPLAY_NAME
            )
            val artistColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.AudioColumns.ARTIST
            )
            val dataColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.AudioColumns.DATA
            )
            val durationColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.AudioColumns.DURATION
            )
            val titleColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.AudioColumns.TITLE
            )
            cursor.apply {
                if (count == 0) {

                }
            }
        }

    }

}