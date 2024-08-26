package com.bmprj.firstweekproject.ui

import com.bmprj.firstweekproject.base.BaseFragment
import com.bmprj.firstweekproject.databinding.FragmentSwitchBinding


class SwitchFragment : BaseFragment<FragmentSwitchBinding>(FragmentSwitchBinding::inflate) {
    override fun setUpViews() {
        setUpListeners()
    }

    private fun setUpListeners() {
        with(binding){
            skySwitch.isEnabled=false
            moonSwitch.isEnabled=false
            oceanSwitch.isEnabled=false
            flameswitch.isEnabled=false
            starSwitch.isEnabled=false

            egoSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
                if(isChecked){
                    skySwitch.isEnabled=false
                    moonSwitch.isEnabled=false
                    oceanSwitch.isEnabled=false
                    flameswitch.isEnabled=false
                    starSwitch.isEnabled=false

                    skySwitch.isChecked=false
                    moonSwitch.isChecked=false
                    oceanSwitch.isChecked=false
                    flameswitch.isChecked=false
                    starSwitch.isChecked=false
                }else{


                    skySwitch.isEnabled=true
                    moonSwitch.isEnabled=true
                    oceanSwitch.isEnabled=true
                    flameswitch.isEnabled=true
                    starSwitch.isEnabled=true
                }
            }
        }

    }

}