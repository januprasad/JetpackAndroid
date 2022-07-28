package com.jk.navigation_compose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PermissionViewModel : ViewModel() {

    private val _hasAudioPermission = mutableStateOf(false)
    private val _hasCameraPermission = mutableStateOf(false)

    val hasCameraPermission = _hasCameraPermission
    val hasAudioPermission = _hasAudioPermission

    fun onPermissionsResult(acceptedAudioPermission: Boolean, acceptedCameraPermission: Boolean) {
        _hasAudioPermission.value = acceptedAudioPermission
        _hasCameraPermission.value = acceptedCameraPermission
    }
}
