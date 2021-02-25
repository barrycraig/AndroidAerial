package com.moaapps.screensaver

import android.net.Uri
import android.os.Environment
import android.service.dreams.DreamService
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import java.io.File
import java.util.*
import kotlin.collections.ArrayList


class ScreenSaverService : DreamService() {
    private lateinit var playerView: PlayerView
    private lateinit var exoPlayer:SimpleExoPlayer
    private val filesList = ArrayList<File>()
    override fun onDreamingStarted() {
        super.onDreamingStarted()
        Log.d("TAG", "onDreamingStarted: ")

        val file = File(Environment.getExternalStorageDirectory(),"Screensaver")
        if (file.exists() && file.isDirectory){
            for (file in file.listFiles()){
                if (file != null && file.absolutePath.endsWith("mov")){
                    filesList.add(file)
                }
            }
        }

        exoPlayer = SimpleExoPlayer.Builder(this).build()
        playerView.player = exoPlayer

        if (filesList.isEmpty()){
            findViewById<TextView>(R.id.no_files).visibility = View.VISIBLE
            findViewById<PlayerView>(R.id.player_view).visibility = View.GONE
        }else{
            setFilesAndPlay()

            exoPlayer.addListener(object : Player.DefaultEventListener() {
                override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                    super.onPlayerStateChanged(playWhenReady, playbackState)
                    if (playbackState == Player.STATE_ENDED){
                        exoPlayer.release()
                        exoPlayer = SimpleExoPlayer.Builder(this@ScreenSaverService).build()
                        setFilesAndPlay()
                    }
                }
            })

        }


    }

    private fun setFilesAndPlay() {
        filesList.shuffle()
        for (file in filesList) {
            val mediaItem = MediaItem.fromUri(Uri.fromFile(file))
            exoPlayer.addMediaItem(mediaItem)
        }

        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    override fun onDreamingStopped() {
        super.onDreamingStopped()
        Log.d("TAG", "onDreamingStopped: ")
        exoPlayer.stop()
        exoPlayer.release()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("TAG", "onAttachedToWindow: ")
        isInteractive = false
        isFullscreen = true
        setContentView(R.layout.screen_saver_layout)
        playerView = findViewById(R.id.player_view)

    }

}