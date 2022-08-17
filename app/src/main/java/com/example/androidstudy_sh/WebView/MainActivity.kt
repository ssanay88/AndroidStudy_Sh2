package com.example.androidstudy_sh.WebView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.room.Room
import com.example.androidstudy_sh.R
import com.example.androidstudy_sh.Room.DAO
import com.example.androidstudy_sh.Room.ItemDB
import com.example.androidstudy_sh.Room.ItemData
import com.example.androidstudy_sh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.settings.javaScriptEnabled = true    // 웹뷰의 자바스크립트 기능을 활성화
        myWebView.addJavascriptInterface(WebAppInterface(this), "YSH")    // YSH라는 JavascriptInterface를 추가

        myWebView.webViewClient = MyWebViewClient()    // 웹 뷰 클라이언트 제공

        myWebView.loadUrl("file:///android_asset/postWeb.html")    // html 파일 연결




    }
}

