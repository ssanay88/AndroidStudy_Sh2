package com.example.androidstudy_sh.WebView

import android.content.Context
import android.content.Intent
import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast
import androidx.room.Room
import com.example.androidstudy_sh.ListView.ListActivity
import com.example.androidstudy_sh.Room.ItemDB
import com.example.androidstudy_sh.Room.ItemData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WebAppInterface(private val mContext: Context) {

    val db = Room.databaseBuilder(mContext, ItemDB::class.java, "ItemDB").build()
    val ItemDao = db.itemDao()


    @JavascriptInterface
    fun showToast() {
        Toast.makeText(mContext, "성공적으로 등록되었습니다.", Toast.LENGTH_SHORT).show()
    }

    @JavascriptInterface
    fun saveData(imgUrl: String, title: String, script: String) {

        val newItem = ItemData(0, imgUrl, title, script)
        Log.d("로그", "새로운 입력 : 제목 : $title, 설명 : $script")

        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch(Dispatchers.IO) {
            ItemDao.insertPost(newItem)    // DB에 저장
        }

    }

    @JavascriptInterface
    fun getList() {
        val intent = Intent(mContext, ListActivity::class.java)
        mContext.startActivity(intent)

    }

}