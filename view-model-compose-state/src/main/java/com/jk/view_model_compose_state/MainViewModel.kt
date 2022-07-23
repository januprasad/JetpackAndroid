package com.jk.view_model_compose_state // ktlint-disable package-name

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textLiveData = MutableLiveData("")
    fun updateText(name: String) {
        textLiveData.value = name
    }
}
