package com.example.recyclerviewexample.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.MyRecyclerViewInterface
import com.example.recyclerviewexample.model.MyModel
import kotlinx.android.synthetic.main.recyclerview_item_list.view.*

class MyViewHolder(itemView: View,
                    recyclerViewInterface: MyRecyclerViewInterface):
                        RecyclerView.ViewHolder(itemView),
                        View.OnClickListener{
    
    val TAG: String = "로그"

    private val userNameTextView = itemView.recyclerview_item_textview
    private val profileImgView = itemView.recyclerview_item_imageview

    private var myRecyclerViewInterface: MyRecyclerViewInterface? = null

    // 기본 생성자
    init {
        Log.d(TAG, "MyViewHolder - init() called")

        itemView.setOnClickListener(this)
        this.myRecyclerViewInterface = recyclerViewInterface
    }

    // 데이터와 뷰를 묶음
    fun bind(myModel: MyModel){
        Log.d(TAG, "MyViewHolder - bind() called")
        userNameTextView.text = myModel.name
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "MyViewHolder - onClick() called")

        this.myRecyclerViewInterface?.onItemClicked(absoluteAdapterPosition)
    }

}