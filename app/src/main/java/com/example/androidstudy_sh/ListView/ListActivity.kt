package com.example.androidstudy_sh.ListView

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.ims.ImsMmTelManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.androidstudy_sh.RecyclerViewAdapter
import com.example.androidstudy_sh.Room.ItemDB
import com.example.androidstudy_sh.Room.ItemData
import com.example.androidstudy_sh.databinding.ActivityListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class ListActivity : AppCompatActivity() {

    lateinit var listBinding: ActivityListBinding
    lateinit var postItems: MutableList<ItemData>
    lateinit var db: ItemDB



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(listBinding.root)

        db = Room.databaseBuilder(applicationContext, ItemDB::class.java, "ItemDB").build()

    }

    override fun onResume() {
        super.onResume()
        val ItemDao = db.itemDao()

        CoroutineScope(Dispatchers.IO).launch {

            postItems = ItemDao.getAll()
            CoroutineScope(Dispatchers.Main).launch {
                var listAdapter = RecyclerViewAdapter(postItems)
                listBinding.messageBoardRv.adapter = listAdapter
                listBinding.messageBoardRv.layoutManager = LinearLayoutManager(applicationContext)
            }

        }





    }




}