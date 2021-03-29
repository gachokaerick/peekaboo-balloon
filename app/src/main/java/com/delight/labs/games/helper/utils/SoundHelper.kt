package com.delight.labs.games.helper.utils

import android.app.Activity
import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import com.delight.labs.games.R

class SoundHelper {
    private var mMusicPlayer: MediaPlayer? = null

    private var mSoundPool: SoundPool? = null
    private var mSoundID = 0
    private var mLoaded = false
    private var mVolume = 0f

    fun SoundHelper(activity: Activity) {
        val audioManager = activity.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val actVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC).toFloat()
        mVolume = actVolume / maxVolume
        activity.volumeControlStream = AudioManager.STREAM_MUSIC
        mSoundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val audioAttrib = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            SoundPool.Builder().setAudioAttributes(audioAttrib).setMaxStreams(6).build()
        } else {
            SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        }
        mSoundPool!!.setOnLoadCompleteListener { soundPool, sampleId, status -> mLoaded = true }
        mSoundID = mSoundPool!!.load(activity, R.raw.balloon_pop, 1)
    }

    fun playSound() {
        if (mLoaded) {
            mSoundPool!!.play(mSoundID, mVolume, mVolume, 1, 0, 1f)
        }
    }

    fun prepareMusicPlayer(context: Context) {
        mMusicPlayer = MediaPlayer.create(context.applicationContext, R.raw.pleasant_music)
        mMusicPlayer!!.setVolume(.5f, .5f)
        mMusicPlayer!!.isLooping = true
    }

    fun playMusic() {
        if (mMusicPlayer != null) {
            mMusicPlayer!!.start()
        }
    }

    fun pauseMusic() {
        if (mMusicPlayer != null && mMusicPlayer!!.isPlaying) {
            mMusicPlayer!!.pause()
        }
    }
}