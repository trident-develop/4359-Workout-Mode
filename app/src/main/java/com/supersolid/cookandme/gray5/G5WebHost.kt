package com.supersolid.cookandme.gray5

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import com.supersolid.cookandme.gray5.webview.CustomWebChromeClient
import com.supersolid.cookandme.gray5.webview.CustomWebView
import com.supersolid.cookandme.gray5.webview.CustomWebViewClient
import com.supersolid.cookandme.gray5.webview.LauncherCallbacks
import com.supersolid.cookandme.gray5.webview.setupView

internal fun launchWebView(
    activity: ComponentActivity,
    url: String,
    storage: G5Storage,
    onStub: () -> Unit,
    fileLauncher: ActivityResultLauncher<String>,
    cameraLauncher: ActivityResultLauncher<String>,
    callbacks: LauncherCallbacks
) {
    val wv     = CustomWebView(activity)
    val client = CustomWebViewClient(activity, onStubRequired = onStub)
    val chrome = CustomWebChromeClient(
        activity, wv,
        onStubRequired = onStub,
        launcher = fileLauncher,
        cameraPermLauncher = cameraLauncher,
        callbackHolder = callbacks
    )
    setupView(wv, client, chrome)
    wv.loadUrl(url)
}
