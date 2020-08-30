package com.ashehata.remote_config

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

const val IS_ENABLED: String = "is_enabled"

fun isAppEnabled(isEnabled: (enabled: Boolean) -> Unit) {

    // Get instance of firebase remote config
    val remoteConfig = Firebase.remoteConfig
    val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 10
        fetchTimeoutInSeconds = 30
    }

    // set settings for it
    remoteConfig.setConfigSettingsAsync(configSettings)
    // set default values for it
    remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);

    remoteConfig.fetchAndActivate().addOnCompleteListener {
        Log.e("addOnCompleteListener", "done")
        val enabled = remoteConfig.getBoolean(IS_ENABLED)
        Log.e("isAppEnabled: ", enabled.toString())
        isEnabled(enabled)
    }


}