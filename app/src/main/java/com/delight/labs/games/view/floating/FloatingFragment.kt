package com.delight.labs.games.view.floating

import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavOptions
import androidx.navigation.fragment.navArgs
import com.delight.labs.games.R
import com.delight.labs.games.aop.annotation.SingleClick
import com.delight.labs.games.databinding.FragmentFloatingBinding
import com.delight.labs.games.helper.Constants.BALLOONS_PER_LEVEL
import com.delight.labs.games.helper.Constants.EASY_SPEED
import com.delight.labs.games.helper.Constants.HARD_SPEED
import com.delight.labs.games.helper.Constants.MAX_ANIMATION_DELAY
import com.delight.labs.games.helper.Constants.MAX_ANIMATION_DURATION
import com.delight.labs.games.helper.Constants.MIN_ANIMATION_DELAY
import com.delight.labs.games.helper.Constants.MIN_ANIMATION_DURATION
import com.delight.labs.games.helper.Constants.NORMAL_SPEED
import com.delight.labs.games.helper.Constants.NUMBER_OF_PINS
import com.delight.labs.games.helper.extens.logD
import com.delight.labs.games.helper.utils.*
import com.delight.labs.games.helper.utils.GameHelper.floatingModeGameOver
import com.delight.labs.games.helper.utils.GameHelper.floatingModePaused
import com.delight.labs.games.helper.utils.GameHelper.floatingModePlaying
import com.delight.labs.games.view.base.BaseFragment
import com.delight.labs.games.view.objects.Balloon
import java.util.*

class FloatingFragment : BaseFragment<FragmentFloatingBinding>(), Balloon.BalloonListener {
    private var mScreenWidth = 0
    private var mScreenHeight = 0

    private var mLevel = 0
    private var mScore: Int = 0
    private var mPinsUsed: Int = 0
    private val mPinImages: MutableList<ImageView> = ArrayList()
    private val mBalloons: MutableList<Balloon> = ArrayList()
    private var mBalloonsPopped = 0
    private lateinit var mSoundHelper: SoundHelper

    private var playIcon: Drawable? = null
    private var pauseIcon: Drawable? = null

    var balloonsLaunchedForCurrentLevel = 0

    private var speed: Int = 500 //default

    private val args: FloatingFragmentArgs by navArgs()

    private var isNightTime: Boolean = false

    private val colors = arrayOf("cyan", "green", "pink", "yellow")
    private val faces = arrayOf("angry", "crazy", "nervous", "scared", "smiling")

    override fun initView() {
        val cal = Calendar.getInstance(TimeZone.getDefault())
        val hour = cal[Calendar.HOUR_OF_DAY]
        isNightTime = hour < 6 || hour > 18

        if (isNightTime) {
            logD("time is night")
            mBinding.rlFloating.setBackgroundResource(R.drawable.night_sky)
        } else {
            logD("time is day")
            mBinding.rlFloating.setBackgroundResource(R.drawable.day_sky)
        }

        balloonsLaunchedForCurrentLevel = 0
        speed = when (args.difficulty) {
            1 -> {
                EASY_SPEED
            }
            2 -> {
                NORMAL_SPEED
            }
            3 -> {
                HARD_SPEED
            }
            else -> {
                EASY_SPEED
            }
        }


        mLevel = 0
        mScore = 0
        mPinsUsed = 0
        mBalloonsPopped = 0

//        activity?.window?.setBackgroundDrawableResource(R.drawable.modern_background)

        setToFullScreen()

        val viewTreeObserver: ViewTreeObserver = mBinding.root.viewTreeObserver
        if (viewTreeObserver.isAlive) {
            viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    mScreenWidth = mBinding.root.width
                    mScreenHeight = mBinding.root.height
                    mBinding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            })
        }

        mBinding.root.setOnClickListener { setToFullScreen() }

        mPinImages.add(mBinding.pushpin1)
        mPinImages.add(mBinding.pushpin2)
        mPinImages.add(mBinding.pushpin3)
        mPinImages.add(mBinding.pushpin4)
        mPinImages.add(mBinding.pushpin5)

        updateDisplay()

        mSoundHelper = SoundHelper(requireActivity())
        mSoundHelper.prepareMusicPlayer(mContext)

        mBinding.tvHighScore.text = getTopScore(mContext).toString()

        pauseIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_pause_24, null)
        playIcon =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_play_arrow_24, null)

        mSoundHelper.playMusic()
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
        mBinding.btnQuit.visibility = View.GONE

        setToFullScreen()
        mScore = 0
        mLevel = 0
        mPinsUsed = 0
        for (pin in mPinImages) {
            pin.setImageResource(R.drawable.pin)
        }
        floatingModeGameOver = false
        startLevel()
    }

    private fun startLevel() {
        mBinding.btnQuit.visibility = View.GONE

        mLevel++
        balloonsLaunchedForCurrentLevel = 0
        updateDisplay()
        val balloonLauncher = BalloonLauncher()
        balloonLauncher.execute(mLevel)
        floatingModePlaying = true
        mBalloonsPopped = 0
        mBinding.goButton.text = resources.getString(R.string.pause)
        pauseIcon?.let {
            mBinding.goButton.setCompoundDrawablesWithIntrinsicBounds(null, null, it, null)
        } ?: logD("pause icon is null")
    }

    private fun finishLevel() {
        floatingModePlaying = false
        mBinding.goButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        mBinding.goButton.text = String.format(Locale.ENGLISH, "Start level %d", mLevel + 1)
        mBinding.btnQuit.visibility = View.VISIBLE
    }

    private fun playGame() {
        if (floatingModePlaying) {
            pauseGame()
        } else if (floatingModePaused) {
            continuePlaying()
        } else if (floatingModeGameOver) {
            startGame()
        } else {
            startLevel()
        }
    }

    override fun popBalloon(balloon: Balloon?, userTouch: Boolean) {
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
            }
        }
        updateDisplay()
        if (mBalloonsPopped == BALLOONS_PER_LEVEL) {
            finishLevel()
        }
    }

    private fun gameOver(allPinsUsed: Boolean) {
        mBinding.btnQuit.visibility = View.VISIBLE

        floatingModeGameOver = true
        mSoundHelper.pauseMusic()
        for (balloon in mBalloons) {
            balloon.setPopped(true)
            (mBinding.root as ViewGroup).removeView(balloon)
        }
        mBalloons.clear()
        floatingModePlaying = false
        floatingModeGameOver = true

        updateDisplay()

        mBinding.goButton.text = resources.getString(R.string.start_game)
        mBinding.goButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)

        if (allPinsUsed) {
            if (isTopScore(mContext, mScore)) {
                setTopScore(mContext, mScore)
                val dialog: SimpleAlertDialog = SimpleAlertDialog.newInstance(
                    "New High Score", String.format(
                        Locale.ENGLISH, "Your new high score is %d", mScore
                    )
                )
                activity?.supportFragmentManager?.let { dialog.show(it, null) }
            }
        }

        mBinding.tvHighScore.text = getTopScore(mContext).toString()
    }

    private fun updateDisplay() {
        mBinding.scoreDisplay.text = mScore.toString()
        mBinding.levelDisplay.text = mLevel.toString()
    }

    private inner class BalloonLauncher : AsyncTask<Int?, Int?, Void?>() {
        override fun doInBackground(vararg params: Int?): Void? {
            if (params.size != 1) {
                throw AssertionError(
                    "Expected 1 param for current level"
                )
            }
            val level = params[0]
            val maxDelay: Int = MIN_ANIMATION_DELAY.coerceAtLeast(
                MAX_ANIMATION_DELAY - ((level?.minus(1))?.times(500) ?: 0)
            )
            val minDelay = maxDelay / 2
            while (floatingModePlaying && balloonsLaunchedForCurrentLevel < BALLOONS_PER_LEVEL && !floatingModePaused) {

//              Get a random horizontal position for the next balloon
                val random = Random(Date().time)
                val xPosition = random.nextInt(mScreenWidth - 200)
                publishProgress(xPosition)
                balloonsLaunchedForCurrentLevel++

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
        val balloon = Balloon(mContext, this, getRandomFace(), 150)
        mBalloons.add(balloon)

        // Set balloon vertical position and dimensions, add to container
        balloon.x = x.toFloat()
        balloon.y = (mScreenHeight + balloon.height).toFloat()
        (mBinding.root as ViewGroup).addView(balloon)

        // Let 'er fly
        val duration: Int =
            MIN_ANIMATION_DURATION.coerceAtLeast(MAX_ANIMATION_DURATION - mLevel * speed)
        balloon.releaseBalloon(mScreenHeight, duration)
    }

    private fun randomize(): Int {
        val min = 0
        val max = 255
        val range = max - min + 1
        return (Math.random() * range + min).toInt()
    }

    @SingleClick
    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.go_button -> {
                playGame()
            }
            R.id.btnQuit -> {
                val builder: AlertDialog.Builder =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        AlertDialog.Builder(mContext, android.R.style.Theme_Material_Dialog_Alert)
                    } else {
                        AlertDialog.Builder(mContext)
                    }
                builder.setTitle(mContext.resources?.getString(R.string.stop_game) ?: "Stop Game")
                    .setMessage(
                        mContext.resources?.getString(R.string.stop_game_confirmation)
                            ?: "Stop the game and go back to menu?"
                    )
                    .setPositiveButton(android.R.string.yes) { _, _ ->
                        gameOver(false)
                        backToMenu()
                    }
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
            }
        }
    }

    private fun backToMenu() {
        navController.navigate(
            R.id.action_floatingFragment_to_fragmentWelcome, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.nav_graph, true)
                .setLaunchSingleTop(true)
                .build()
        )
    }

    private fun pauseGame() {
        mBinding.btnQuit.visibility = View.VISIBLE

        mBalloons.forEach {
            if (!it.mPopped) {
                it.mAnimator?.pause()
            }
        }
        mSoundHelper.pauseMusic()
        mBinding.goButton.text = resources.getString(R.string.continue_game)

        playIcon?.let {
            mBinding.goButton.setCompoundDrawablesWithIntrinsicBounds(null, null, it, null)
        } ?: logD("play icon null!")
        floatingModePlaying = false
        floatingModePaused = true
    }

    private fun continuePlaying() {
        mBinding.btnQuit.visibility = View.GONE

        mBalloons.forEach {
            if (!it.mPopped) {
                it.mAnimator?.resume()
            }
        }
        mSoundHelper.playMusic()
        mBinding.goButton.text = resources.getString(R.string.pause)

        val balloonLauncher = BalloonLauncher()
        balloonLauncher.execute(mLevel)

        pauseIcon?.let {
            mBinding.goButton.setCompoundDrawablesWithIntrinsicBounds(null, null, it, null)
        } ?: logD("pause icon null!")
        floatingModePlaying = true
        floatingModePaused = false
    }

    private fun getRandomFace(): Int {
        val face = faces.random()
        val color = colors.random()
        val fileName: String = "ic_$face" + "_face_$color"
        return resources.getIdentifier(fileName, "drawable", mContext.packageName)
    }
}