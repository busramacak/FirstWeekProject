package com.bmprj.firstweekproject.ui

import android.view.Menu
import android.view.View
import android.widget.CompoundButton
import com.bmprj.firstweekproject.R
import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentSwitchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
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
            skySwitch.setOnCheckedChangeListener{ _,isChecked ->
                if(isChecked){
                   if(bottomNavigationView.menu.findItem(R.id.skyFragment) == null){
                       bottomNavigationView.menu.add(Menu.NONE, R.id.skyFragment, Menu.NONE,"Sky").setIcon(R.drawable.switch_icon)
                   }
                }else{
                    bottomNavigationView.menu.removeItem(R.id.skyFragment)
                }

            }

            moonSwitch.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    if(bottomNavigationView.menu.findItem(R.id.moonFragment) == null){
                        bottomNavigationView.menu.add(Menu.NONE, R.id.moonFragment, Menu.NONE,"Moon").setIcon(R.drawable.switch_icon)
                    }
                }else{
                    bottomNavigationView.menu.removeItem(R.id.moonFragment)
                }
            }

            bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
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