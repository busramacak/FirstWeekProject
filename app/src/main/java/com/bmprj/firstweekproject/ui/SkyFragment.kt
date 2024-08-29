package com.bmprj.firstweekproject.ui


import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Path
import android.view.View
import androidx.core.content.ContextCompat.getColor
import com.bmprj.firstweekproject.R
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentSkyBinding


class SkyFragment : BaseFragment<FragmentSkyBinding>(FragmentSkyBinding::inflate) {
    override fun setUpViews() {
        setUpAnimate()
    }

    private fun setUpAnimate() {

        val colorNight = getColor(requireContext(), R.color.night)
        val colorDawn = getColor(requireContext(), R.color.dawn)
        val colorDay = getColor(requireContext(), R.color.day)
        val colorDusk = getColor(requireContext(), R.color.dusk)
        val sun = binding.sun

        val colorAnimation = ObjectAnimator.ofArgb(
            binding.skyBackground,
            "backgroundColor",
            colorNight,
            colorDawn,
            colorDay,
            colorDusk,
            colorNight
        ).apply {
            duration = 10000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val path = Path().apply {
            moveTo(-450f, 800f)
            quadTo(300f, -800f, 1100f, 700f)
        }

        val sunPathAnimation = ObjectAnimator.ofFloat(sun, View.X, View.Y, path).apply {
            duration = 10000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(colorAnimation, sunPathAnimation)
        animatorSet.start()
    }
}