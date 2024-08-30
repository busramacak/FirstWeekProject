package com.bmprj.firstweekproject.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Path
import android.view.View
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentStarBinding

class StarFragment : BaseFragment<FragmentStarBinding>(FragmentStarBinding::inflate) {
    override fun setUpViews() {
        setUpAnimate()
    }

    private fun setUpAnimate() {
        val path1 = Path().apply {
            moveTo(1100f, 0f)
            quadTo(500f, 100f, -200f, 700f)
        }

        val starPathAnimation1 = ObjectAnimator.ofFloat(binding.star1, View.X, View.Y, path1).apply {
            duration = 3000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path2 = Path().apply {
            moveTo(1100f, 150f)
            quadTo(500f, 250f, -200f, 850f)
        }

        val starPathAnimation2 = ObjectAnimator.ofFloat(binding.star2, View.X, View.Y, path2).apply {
            duration = 5000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path3 = Path().apply {
            moveTo(1100f, 300f)
            quadTo(500f, 400f, -200f, 1000f)
        }

        val starPathAnimation3 = ObjectAnimator.ofFloat(binding.star3, View.X, View.Y, path3).apply {
            duration = 2000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path4 = Path().apply {
            moveTo(1100f, 450f)
            quadTo(500f, 550f, -200f, 1150f)
        }

        val starPathAnimation4 = ObjectAnimator.ofFloat(binding.star4, View.X, View.Y, path4).apply {
            duration = 3500L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path5 = Path().apply {
            moveTo(1100f, 950f)
            quadTo(500f, 700f, -200f, 1300f)
        }

        val starPathAnimation5 = ObjectAnimator.ofFloat(binding.star5, View.X, View.Y, path5).apply {
            duration = 2000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path6 = Path().apply {
            moveTo(1100f, 1300f)
            quadTo(500f, 1200f, -200f, 1650f)
        }

        val starPathAnimation6 = ObjectAnimator.ofFloat(binding.star6, View.X, View.Y, path6).apply {
            duration = 1000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val starAnimatorSet = AnimatorSet().apply {
            playTogether(starPathAnimation1, starPathAnimation2,starPathAnimation3,starPathAnimation4,starPathAnimation5,starPathAnimation6)
        }
        starAnimatorSet.start()
    }
}