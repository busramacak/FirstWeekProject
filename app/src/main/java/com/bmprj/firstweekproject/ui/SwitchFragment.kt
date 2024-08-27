package com.bmprj.firstweekproject.ui

import android.view.Menu
import android.view.View
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
                    bottomNavigationView.addItem(R.id.skyFragment,"Sky",R.drawable.switch_icon)
                }else{
                    bottomNavigationView.removeItem(R.id.skyFragment)
                }

            }

            moonSwitch.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    bottomNavigationView.addItem(R.id.moonFragment, "Moon", R.drawable.switch_icon)
                }else{
                    bottomNavigationView.removeItem(R.id.moonFragment)
                }
            }
            bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        }

    }

    private fun  BottomNavigationView.addItem(itemId:Int, itemTitle:String, icon:Int){
        if(this.menu.findItem(itemId) == null){
            this.menu.add(Menu.NONE, itemId, Menu.NONE, itemTitle).setIcon(icon)

        }
    }

    private fun BottomNavigationView.removeItem(itemId: Int) {
        this.menu.removeItem(itemId)
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