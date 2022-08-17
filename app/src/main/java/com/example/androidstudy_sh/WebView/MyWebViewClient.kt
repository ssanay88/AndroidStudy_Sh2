package com.example.androidstudy_sh.WebView

import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient



class MyWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

        if (Uri.parse(url).host == "file:///android_asset/postWeb.html") {
            return false
        }



        return true
    }


}