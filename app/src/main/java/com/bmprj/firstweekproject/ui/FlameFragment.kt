package com.bmprj.firstweekproject.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Path
import android.view.View
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentFlameBinding


class FlameFragment : BaseFragment<FragmentFlameBinding>(FragmentFlameBinding::inflate) {
    override fun setUpViews() {
        setUpAnimate()
    }

    private fun setUpAnimate() {
        val path1 = Path().apply {
            moveTo(650f, 800f)
            quadTo(660f, 790f, 650f, 800f)
        }

        val sunPathAnimation1 = ObjectAnimator.ofFloat(binding.jrFlame1, View.X, View.Y, path1).apply {
            duration = 2000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }

        val path2 = Path().apply {
            moveTo(690f, 750f)
            quadTo(700f, 760f, 690f, 750f)
        }

        val sunPathAnimation2 = ObjectAnimator.ofFloat(binding.jrFlame2, View.X, View.Y, path2).apply {
            duration = 1000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }

        val path3 = Path().apply {
            moveTo(750f, 830f)
            quadTo(740f, 820f, 750f, 830f)
        }

        val sunPathAnimation3 = ObjectAnimator.ofFloat(binding.jrFlame3, View.X, View.Y, path3).apply {
            duration = 2000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }

        val animatorSet = AnimatorSet()
        animatorSet.playTogether( sunPathAnimation1,sunPathAnimation2,sunPathAnimation3)
        animatorSet.start()
    }

}