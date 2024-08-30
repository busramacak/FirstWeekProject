package com.bmprj.firstweekproject.ui

import android.view.View
import androidx.core.view.size
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bmprj.firstweekproject.R
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentSwitchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.navigation.NavigationBarView


class SwitchFragment : BaseFragment<FragmentSwitchBinding>(FragmentSwitchBinding::inflate) {

    private val viewModel: SwitchViewModel by viewModels()

    private val bottomNavigationView by lazy {
        requireActivity().findViewById<BottomNavigationView>(
            R.id.bottomNavigationBar
        )
    }

    override fun setUpViews() {
        setUpListeners()
        setUpLiveDataObservers()
    }

    private fun setUpLiveDataObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.switchStates.collect { states ->
                binding.skySwitch.isChecked = states["Sky"] ?: false
                binding.moonSwitch.isChecked = states["Moon"] ?: false
                binding.oceanSwitch.isChecked = states["Ocean"] ?: false
                binding.flameswitch.isChecked = states["Flame"] ?: false
                binding.starSwitch.isChecked = states["Star"] ?: false
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.enabled.collect { isEnabled ->
                setSwitchEnabled(isEnabled)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.egoSwitchChecked.collect { isChecked ->
                if (isChecked) {
                    setSwitchEnabled(false)
                } else {
                    setSwitchEnabled(true)

                }
            }
        }
    }

    private fun setUpListeners() {
        with(binding) {

            egoSwitch.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setEgoSwitchState(isChecked)
            }



            setupSwitchListener(skySwitch, R.id.skyFragment, "Sky", R.drawable.sky_icon)
            setupSwitchListener(moonSwitch, R.id.moonFragment, "Moon", R.drawable.icon_moon)
            setupSwitchListener(oceanSwitch, R.id.oceanFragment, "Ocean", R.drawable.icon_ocean)
            setupSwitchListener(flameswitch, R.id.flameFragment, "Flame", R.drawable.icon_flame)
            setupSwitchListener(starSwitch, R.id.starFragment, "Star", R.drawable.icon_star)

            bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        }

    }

    fun setupSwitchListener(
        switch: MaterialSwitch,
        itemId: Int,
        itemTitle: String,
        itemIcon: Int,
    ) {
        switch.setOnCheckedChangeListener { _, isChecked ->

            if (bottomNavigationView.menu.size <= 5) {
                if (isChecked && bottomNavigationView.menu.size != 5) {
                    viewModel.addItem(
                        itemId,
                        itemTitle,
                        itemIcon,
                        bottomNavigationView.menu
                    )
                    viewModel.setSwitchState(itemTitle, true)
                } else if (!isChecked) {
                    viewModel.removeItem(itemId, bottomNavigationView.menu)
                    viewModel.setSwitchState(itemTitle, false)
                }
            }

        }
    }

    private fun setSwitchEnabled(enabled: Boolean) {
        with(binding) {
            bottomNavigationView.visibility = if (enabled) View.VISIBLE else View.GONE
            listOf(skySwitch, moonSwitch, oceanSwitch, flameswitch, starSwitch).forEach {
                it.isEnabled = enabled
            }
        }
    }

}