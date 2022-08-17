package com.example.androidstudy_sh

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidstudy_sh.Room.ItemData
import com.example.androidstudy_sh.databinding.PostItemBinding

class RecyclerViewAdapter(val itemDatas : MutableList<ItemData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder =
        MyViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int {
        return itemDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).ItemBinding
        binding.titleTv.text = itemDatas[position].title
        binding.subscriptTv.text = itemDatas[position].subscript
        Glide.with(holder.itemView.context)
            .load(itemDatas[position].imgUrl)
            .into(binding.mainImageIv)
    }
}

class MyViewHolder(val ItemBinding: PostItemBinding) : RecyclerView.ViewHolder(ItemBinding.root) {
//        private var imageView : ImageView = view.findViewById(R.id.mainImage_iv)
//        private var titleTextView : TextView = view.findViewById(R.id.title_tv)
//        private var scriptTextView : TextView = view.findViewById(R.id.subscript_tv)

    fun bind(dataMap: ItemData) {
        ItemBinding.titleTv.text = dataMap.title
        ItemBinding.subscriptTv.text = dataMap.subscript
        Glide.with(itemView)
            .load(dataMap.imgUrl)
            .into(ItemBinding.mainImageIv)

        Log.d("로그", "이미지 : ${dataMap.imgUrl} , 제목 : ${dataMap.title} , 설명 : ${dataMap.subscript}")

    }
}