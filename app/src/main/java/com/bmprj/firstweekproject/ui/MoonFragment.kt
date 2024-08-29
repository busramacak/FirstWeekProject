package com.bmprj.firstweekproject.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Path
import android.view.View
import androidx.core.content.ContextCompat.getColor
import com.bmprj.firstweekproject.R
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentMoonBinding


class MoonFragment : BaseFragment<FragmentMoonBinding>(FragmentMoonBinding::inflate) {
    override fun setUpViews() {
        setUpAnimate()
    }

    private fun setUpAnimate() {

        val colorNightSky = getColor(requireContext(), R.color.night_sky)
        val colorDawnSky = getColor(requireContext(), R.color.dawn_sky)
        val colorDaylightSky = getColor(requireContext(), R.color.daylight_sky)
        val colorDuskSky = getColor(requireContext(), R.color.dusk_sky)

        val path = Path().apply {
            moveTo(-500f, 500f)
            quadTo(500f, 100f, 1000f, 450f)
        }

        val moonPathAnimation = ObjectAnimator.ofFloat(binding.moon, View.X, View.Y, path).apply {
            duration = 10000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val nightColorAnimation = ObjectAnimator.ofArgb(
            binding.nightSky,
            "backgroundColor",
            colorNightSky,
            colorDawnSky,
            colorDaylightSky,
            colorDuskSky,
            colorNightSky
        ).apply {
            duration = 10000L
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }

        val moonAnimatorSet = AnimatorSet().apply {
            playTogether(moonPathAnimation, nightColorAnimation)
        }
        moonAnimatorSet.start()
    }
}