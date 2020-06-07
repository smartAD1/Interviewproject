package com.example.interviewproject.Utils

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController

fun NavController.safeNavigate(@IdRes actionId: Int, bundle: Bundle) {
    currentDestination?.getAction(actionId)?.let {
        navigate(actionId, bundle)
    }
}