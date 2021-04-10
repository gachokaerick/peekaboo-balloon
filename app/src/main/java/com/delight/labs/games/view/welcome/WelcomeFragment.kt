package com.delight.labs.games.view.welcome

import android.view.View
import androidx.navigation.NavOptions
import com.delight.labs.games.R
import com.delight.labs.games.aop.annotation.SingleClick
import com.delight.labs.games.databinding.FragmentWelcomeBinding
import com.delight.labs.games.helper.Constants.EASY_DIFFICULTY
import com.delight.labs.games.helper.Constants.HARD_DIFFICULTY
import com.delight.labs.games.helper.Constants.NORMAL_DIFFICULTY
import com.delight.labs.games.helper.utils.SoundHelperWelcome
import com.delight.labs.games.view.base.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    private lateinit var mSoundHelper: SoundHelperWelcome
    override fun initView() {
        mSoundHelper = SoundHelperWelcome(requireActivity())
        mSoundHelper.prepareMusicPlayer(mContext)
        mSoundHelper.playMusic()
    }

    override fun loadData(isRefresh: Boolean) {
    }

    override fun getLayoutId(): Int = R.layout.fragment_welcome

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

    @SingleClick
    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.btnEasy -> {
                mSoundHelper.pauseMusic()
                val action = WelcomeFragmentDirections.actionFragmentWelcomeToFloatingFragment(
                    EASY_DIFFICULTY
                )
                navController.navigate(
                    action,
                    NavOptions.Builder()
                        .build()
                )
            }
            R.id.btnNormal -> {
                mSoundHelper.pauseMusic()
                val action = WelcomeFragmentDirections.actionFragmentWelcomeToFloatingFragment(
                    NORMAL_DIFFICULTY
                )
                navController.navigate(
                    action,
                    NavOptions.Builder()
                        .build()
                )
            }
            R.id.btnHard -> {
                mSoundHelper.pauseMusic()
                val action = WelcomeFragmentDirections.actionFragmentWelcomeToFloatingFragment(
                    HARD_DIFFICULTY
                )
                navController.navigate(
                    action,
                    NavOptions.Builder()
                        .build()
                )
            }
        }
    }
}