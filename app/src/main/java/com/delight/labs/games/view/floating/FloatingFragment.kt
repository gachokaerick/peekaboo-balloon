package com.delight.labs.games.view.floating

import android.graphics.Color
import android.os.AsyncTask
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.delight.labs.games.R
import com.delight.labs.games.databinding.FragmentFloatingBinding
import com.delight.labs.games.helper.utils.SimpleAlertDialog
import com.delight.labs.games.helper.utils.SoundHelper
import com.delight.labs.games.helper.utils.isTopScore
import com.delight.labs.games.helper.utils.setTopScore
import com.delight.labs.games.view.base.BaseFragment
import com.delight.labs.games.view.objects.Balloon
import java.util.*

class FloatingFragment : BaseFragment<FragmentFloatingBinding>() {
    private val MIN_ANIMATION_DELAY = 500
    private val MAX_ANIMATION_DELAY = 1500
    private val MIN_ANIMATION_DURATION = 1000
    private val MAX_ANIMATION_DURATION = 8000
    private val NUMBER_OF_PINS = 5
    private val BALLOONS_PER_LEVEL = 3
    private var mPlaying = false
    private var mScreenWidth = 0
    private var mScreenHeight = 0

    private var mLevel = 0
    private var mScore: Int = 0
    private var mPinsUsed: Int = 0
    private val mScoreDisplay: TextView? = null
    private var mLevelDisplay: TextView? = null
    private val mPinImages: List<ImageView> = ArrayList()
    private val mBalloons: MutableList<Balloon> = ArrayList()
    private val mGoButton: Button? = null
    private var mGameStopped = true
    private var mBalloonsPopped = 0
    private lateinit var mSoundHelper: SoundHelper

    override fun initView() {
        activity?.window?.setBackgroundDrawableResource(R.drawable.modern_background)
    }

    override fun loadData(isRefresh: Boolean) {
    }

    override fun getLayoutId(): Int = R.layout.fragment_floating

    private fun setToFullScreen() {
        mBinding.root.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    override fun onResume() {
        super.onResume()
        setToFullScreen()
    }

    private fun startGame() {
        setToFullScreen()
        mScore = 0
        mLevel = 0
        mPinsUsed = 0
        for (pin in mPinImages) {
            pin.setImageResource(R.drawable.pin)
        }
        mGameStopped = false
        startLevel()
        mSoundHelper.playMusic()
    }

    private fun startLevel() {
        mLevel++
        updateDisplay()
        val balloonLauncher = BalloonLauncher()
        balloonLauncher.execute(mLevel)
        mPlaying = true
        mBalloonsPopped = 0
        mGoButton!!.text = "Stop game"
    }

    private fun finishLevel() {
        Toast.makeText(
            mContext, String.format(Locale.ENGLISH, "You finished level %d", mLevel),
            Toast.LENGTH_SHORT
        ).show()
        mPlaying = false
        mGoButton!!.text = String.format(Locale.ENGLISH, "Start level %d", ++mLevel)
    }

    fun playGame(view: View?) {
        if (mPlaying) {
            gameOver(false)
        } else if (mGameStopped) {
            startGame()
        } else {
            startLevel()
        }
    }

    fun popBalloon(balloon: Balloon?, userTouch: Boolean) {
        mBalloonsPopped++
        mSoundHelper.playSound()
        (mBinding.root as ViewGroup).removeView(balloon)
        mBalloons.remove(balloon)
        if (userTouch) {
            mScore++
        } else {
            mPinsUsed++
            if (mPinsUsed <= mPinImages.size) {
                mPinImages[mPinsUsed - 1].setImageResource(R.drawable.pin_off)
            }
            if (mPinsUsed == NUMBER_OF_PINS) {
                gameOver(true)
                return
            } else {
                Toast.makeText(mContext, "Missed that one!", Toast.LENGTH_SHORT).show()
            }
        }
        updateDisplay()
        if (mBalloonsPopped == BALLOONS_PER_LEVEL) {
            finishLevel()
        }
    }

    private fun gameOver(allPinsUsed: Boolean) {
        Toast.makeText(mContext, "Game over!", Toast.LENGTH_SHORT).show()
        mSoundHelper.pauseMusic()
        for (balloon in mBalloons) {
            balloon.setPopped(true)
            (mBinding.root as ViewGroup).removeView(balloon)
        }
        mBalloons.clear()
        mPlaying = false
        mGameStopped = true
        mGoButton!!.text = "Start Game"
        if (allPinsUsed) {
            if (isTopScore(mContext, mScore)) {
                setTopScore(mContext, mScore)
                val dialog: SimpleAlertDialog = SimpleAlertDialog.newInstance(
                    "Hew High Score", String.format(
                        Locale.ENGLISH, "Your new high score is %d", mScore
                    )
                )
                activity?.supportFragmentManager?.let { dialog.show(it, null) }
            }
        }
    }

    private fun updateDisplay() {
        mScoreDisplay!!.text = mScore.toString()
        mLevelDisplay!!.text = mLevel.toString()
    }

    private inner class BalloonLauncher : AsyncTask<Int?, Int?, Void?>() {
        override fun doInBackground(vararg params: Int?): Void? {
            if (params.size != 1) {
                throw AssertionError(
                    "Expected 1 param for current level"
                )
            }
            val level = params[0]
            val maxDelay: Int = Math.max(
                MIN_ANIMATION_DELAY,
                MAX_ANIMATION_DELAY - ((level?.minus(1))?.times(500) ?: 0)
            )
            val minDelay = maxDelay / 2
            var balloonsLaunched = 0
            while (mPlaying && balloonsLaunched < BALLOONS_PER_LEVEL) {

//              Get a random horizontal position for the next balloon
                val random = Random(Date().time)
                val xPosition = random.nextInt(mScreenWidth - 200)
                publishProgress(xPosition)
                balloonsLaunched++

//              Wait a random number of milliseconds before looping
                val delay = random.nextInt(minDelay) + minDelay
                try {
                    Thread.sleep(delay.toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val xPosition = values[0]
            if (xPosition != null) {
                launchBalloon(xPosition)
            }
        }

    }

    fun launchBalloon(x: Int) {
        val balloon = Balloon(mContext, getRandomColor(), 150)
        mBalloons.add(balloon)

//      Set balloon vertical position and dimensions, add to container
        balloon.x = x.toFloat()
        balloon.y = (mScreenHeight + balloon.height).toFloat()
        (mBinding.root as ViewGroup).addView(balloon)

//      Let 'er fly
        val duration: Int = Math.max(
            MIN_ANIMATION_DURATION,
            MAX_ANIMATION_DURATION - mLevel * 1000
        )
        balloon.releaseBalloon(mScreenHeight, duration)
    }

    private fun getRandomColor(): Int {
        return Color.argb(255, randomize(), randomize(), randomize())
    }

    private fun randomize(): Int {
        val min = 0
        val max = 255
        val range = max - min + 1
        return (Math.random() * range + min).toInt()
    }
}