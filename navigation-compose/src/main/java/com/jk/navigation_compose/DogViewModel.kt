package com.jk.navigation_compose

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val _puppyName = mutableStateOf(TextFieldState())
    val puppyName: State<TextFieldState> = _puppyName

    fun onPuppyNameEnter(name: String) {
        if (puppyName.value.text.isNotBlank() && _puppyName.value.error != null) {
            _puppyName.value = puppyName.value.copy(
                error = null
            )
        }
        _puppyName.value = puppyName.value.copy(
            text = name
        )
    }

    private val _OnSubmit = MutableSharedFlow<String>()
    val OnSubmit = _OnSubmit.asSharedFlow()

    fun onSubmitText() {
        if (puppyName.value.text.isBlank()) {
            _puppyName.value = puppyName.value.copy(
                error = "The puppy name can't be empty"
            )
            return
        }
        viewModelScope.launch {
            _OnSubmit.emit(puppyName.value.text)
        }
    }

    val dogs = mutableStateListOf(
        Dog(1, "Puppy"),
        Dog(2, "Jimmi"),
        Dog(3, "Sofia"),
        Dog(4, "Appu"),
        Dog(5, "Kichu"),
        Dog(6, "Pooopi")
    )
}
