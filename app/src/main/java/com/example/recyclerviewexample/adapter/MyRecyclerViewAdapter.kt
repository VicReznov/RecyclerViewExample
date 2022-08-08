package com.example.recyclerviewexample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.MyRecyclerViewInterface
import com.example.recyclerviewexample.R
import com.example.recyclerviewexample.model.MyModel
import com.example.recyclerviewexample.viewholder.MyViewHolder

class MyRecyclerViewAdapter(myRecyclerviewInterface: MyRecyclerViewInterface): RecyclerView.Adapter<MyViewHolder>() {

    val TAG: String = "로그"

    private var modelList = mutableListOf<MyModel>()

    private var myRecyclerviewInterface: MyRecyclerViewInterface? = null

    // 생성자
    init {
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }

    // 뷰홀더가 생성되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // 연결할 레이아웃 설정
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_list, parent, false), this.myRecyclerviewInterface!!)
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position : ${position}")
        holder.bind(this.modelList[position])
    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: MutableList<MyModel>){
        this.modelList = modelList
    }

}