package com.bmprj.firstweekproject.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Path
import android.view.View
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentOceanBinding


class OceanFragment : BaseFragment<FragmentOceanBinding>(FragmentOceanBinding::inflate) {
    override fun setUpViews() {
        setUpAnimate()
    }

    private fun setUpAnimate() {
        val path1 = Path().apply {
            moveTo(1200f, 200f)
            quadTo(500f, 400f, -200f, 100f)
        }

        val oceanPathAnimation1 = ObjectAnimator.ofFloat(binding.fish1, View.X, View.Y, path1).apply {
            duration = 5000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path2 = Path().apply {
            moveTo(-200f, 0f)
            quadTo(300f, 10f, 600f, 0f)
            quadTo(800f, 10f, 1200f, 0f)
        }

        val oceanPathAnimation2 = ObjectAnimator.ofFloat(binding.fish2, View.X, View.Y, path2).apply {
            duration = 4000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path3 = Path().apply {
            moveTo(-200f, 400f)
            quadTo(300f, 700f, 600f, 500f)
            quadTo(800f, 600f, 1200f, 800f)
        }

        val oceanPathAnimation3 = ObjectAnimator.ofFloat(binding.fish3, View.X, View.Y, path3).apply {
            duration = 5000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path4 = Path().apply {
            moveTo(1200f, 700f)
            quadTo(700f, 800f, 500f, 700f)
            quadTo(300f, 900f, -200f, 1000f)
        }

        val oceanPathAnimation4 = ObjectAnimator.ofFloat(binding.fish4, View.X, View.Y, path4).apply {
            duration = 3000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path5 = Path().apply {
            moveTo(1200f, 1400f)
            quadTo(500f, 1300f, -200f, 1500f)
        }

        val oceanPathAnimation5 = ObjectAnimator.ofFloat(binding.fish5, View.X, View.Y, path5).apply {
            duration = 7000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val oceanAnimatorSet = AnimatorSet().apply {
            playTogether(oceanPathAnimation1, oceanPathAnimation2,oceanPathAnimation3,oceanPathAnimation4,oceanPathAnimation5)
        }
        oceanAnimatorSet.start()
    }
}