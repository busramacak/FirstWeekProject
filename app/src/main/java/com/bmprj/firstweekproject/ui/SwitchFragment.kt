package com.bmprj.firstweekproject.ui

import android.view.Menu
import android.view.View
import androidx.core.view.size
import com.bmprj.firstweekproject.R
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentSwitchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.navigation.NavigationBarView


class SwitchFragment : BaseFragment<FragmentSwitchBinding>(FragmentSwitchBinding::inflate) {

    private val bottomNavigationView by lazy {
        requireActivity().findViewById<BottomNavigationView>(
            R.id.bottomNavigationBar
        )
    }

    override fun setUpViews() {
        setUpListeners()
    }

    private fun setUpListeners() {
        with(binding) {

            if (egoSwitch.isChecked) {
                disableSwitch()
            }
            egoSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    disableSwitch()
                    uncheckSwitch()
                } else {
                    enableSwitch()
                }
            }

            fun setupSwitchListener(
                switch: MaterialSwitch,
                itemId: Int,
                itemTitle: String,
                itemIcon: Int,
            ) {
                switch.setOnCheckedChangeListener { _, isChecked ->
                    if(bottomNavigationView.menu.size <= 5 && isChecked) {
                        if(bottomNavigationView.menu.size != 5) {
                            addItem(itemId, itemTitle, itemIcon)
                        }
                    }else{
                        switch.isChecked = false
                            removeItem(itemId)
                    }
                }
            }

                setupSwitchListener(skySwitch, R.id.skyFragment, "Sky", R.drawable.sky_icon)
                setupSwitchListener(moonSwitch, R.id.moonFragment, "Moon", R.drawable.icon_moon)
                setupSwitchListener(oceanSwitch, R.id.oceanFragment, "Ocean", R.drawable.icon_ocean)
                setupSwitchListener(flameswitch, R.id.flameFragment, "Flame", R.drawable.icon_flame)
                setupSwitchListener(starSwitch, R.id.starFragment, "Star", R.drawable.icon_star)

            bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        }

    }


    private fun addItem(itemId: Int, itemTitle: String, icon: Int) {
        if(bottomNavigationView.menu.findItem(itemId) == null) {
            bottomNavigationView.menu.add(Menu.NONE, itemId, Menu.NONE, itemTitle).setIcon(icon)
        }
    }

    private fun removeItem(itemId: Int) {
        bottomNavigationView.menu.removeItem(itemId)
    }

    private fun disableSwitch() {
        setSwitchEnabled(false)
    }

    private fun enableSwitch() {
        setSwitchEnabled(true)
    }

    private fun uncheckSwitch() {
        with(binding) {
            listOf(skySwitch, moonSwitch, oceanSwitch, flameswitch, starSwitch).forEach {
                it.isChecked = false
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