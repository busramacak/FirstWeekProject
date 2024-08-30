package com.bmprj.firstweekproject.ui

import android.view.Menu
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SwitchViewModel : ViewModel() {

    private val _switchStates = MutableStateFlow(
        mapOf(
            "Sky" to false,
            "Moon" to false,
            "Ocean" to false,
            "Flame" to false,
            "Star" to false
        )
    )
    val switchStates: StateFlow<Map<String, Boolean>> = _switchStates

    private val _enabled = MutableStateFlow(true)
    val enabled: StateFlow<Boolean> = _enabled

    private val _egoSwitchChecked = MutableStateFlow(true)
    val egoSwitchChecked: StateFlow<Boolean> = _egoSwitchChecked

    fun setSwitchState(switchName: String, isChecked: Boolean) {
        _switchStates.value = _switchStates.value.toMutableMap().apply {
            this[switchName] = isChecked
        }
    }

    fun setEgoSwitchState(isChecked: Boolean) {
        _egoSwitchChecked.value = isChecked
        if (isChecked) {
            _switchStates.value = _switchStates.value.mapValues { false }
            _enabled.value = false
        } else {
            _enabled.value = true
        }
    }

    fun addItem(itemId: Int, itemTitle: String, icon: Int, menu: Menu) {
        if (menu.findItem(itemId) == null) {
            menu.add(Menu.NONE, itemId, Menu.NONE, itemTitle).setIcon(icon)
        }
    }

    fun removeItem(itemId: Int, menu: Menu) {
        menu.removeItem(itemId)
    }
}