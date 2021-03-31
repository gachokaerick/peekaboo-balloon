package com.delight.labs.games.view.welcome

import android.view.View
import androidx.navigation.NavOptions
import com.delight.labs.games.R
import com.delight.labs.games.aop.annotation.SingleClick
import com.delight.labs.games.databinding.FragmentWelcomeBinding
import com.delight.labs.games.view.base.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    override fun initView() {
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
            R.id.cvFloating -> {
                navController.navigate(
                    R.id.action_fragmentWelcome_to_floatingFragment, null,
                    NavOptions.Builder()
                        .build()
                )
            }
            R.id.cvPeekaboo -> {

            }
        }
    }
}