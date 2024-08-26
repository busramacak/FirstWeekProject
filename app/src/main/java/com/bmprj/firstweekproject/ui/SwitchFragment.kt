package com.bmprj.firstweekproject.ui

import android.view.View
import com.bmprj.firstweekproject.R
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentSwitchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


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
        }

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