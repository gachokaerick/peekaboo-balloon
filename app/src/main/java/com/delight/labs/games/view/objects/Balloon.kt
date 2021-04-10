package com.delight.labs.games.view.objects

import android.animation.Animator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.content.Context
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatImageView
import com.delight.labs.games.R
import com.delight.labs.games.helper.utils.GameHelper.floatingModePaused
import com.delight.labs.games.helper.utils.pixelsToDp

class Balloon : AppCompatImageView, Animator.AnimatorListener,
    AnimatorUpdateListener {
    var mAnimator: ValueAnimator? = null
    var mListener: BalloonListener? = null
    var mPopped = false

    constructor(context: Context) : super(context)

    constructor(context: Context, balloonListener: BalloonListener, drawable: Int, rawHeight: Int) : super(context) {
        mListener = balloonListener
        setImageResource(drawable)
        val rawWidth = rawHeight / 2
        val dpHeight: Int = pixelsToDp(rawHeight, context)
        val dpWidth: Int = pixelsToDp(rawWidth, context)
        val params = ViewGroup.LayoutParams(dpWidth, dpHeight)
        layoutParams = params
    }

    fun releaseBalloon(screenHeight: Int, duration: Int) {
        mAnimator = ValueAnimator()
        mAnimator!!.duration = duration.toLong()
        mAnimator!!.setFloatValues(screenHeight.toFloat(), 0f)
        mAnimator!!.interpolator = LinearInterpolator()
        mAnimator!!.setTarget(this)
        mAnimator!!.addListener(this)
        mAnimator!!.addUpdateListener(this)
        mAnimator!!.start()
    }

    override fun onAnimationStart(animation: Animator) {}
    override fun onAnimationEnd(animation: Animator) {
        if (!mPopped) {
            mListener!!.popBalloon(this, false)
        }
    }

    override fun onAnimationCancel(animation: Animator) {}
    override fun onAnimationRepeat(animation: Animator) {}
    override fun onAnimationUpdate(animation: ValueAnimator) {
        y = (animation.animatedValue as Float)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!mPopped && event.action == MotionEvent.ACTION_DOWN && !floatingModePaused) {
            mListener!!.popBalloon(this, true)
            mPopped = true
            mAnimator!!.cancel()
        }
        return super.onTouchEvent(event)
    }

    fun setPopped(b: Boolean) {
        mPopped = true
        if (b) {
            mAnimator!!.cancel()
        }
    }

    interface BalloonListener {
        fun popBalloon(balloon: Balloon?, userTouch: Boolean)
    }
}