package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapter.MyRecyclerViewAdapter
import com.example.recyclerviewexample.model.MyModel
import com.example.recyclerviewexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyRecyclerViewInterface {
    lateinit var binding: ActivityMainBinding
    val TAG: String = "로그"

    // 데이터 담을 배열
    var modelList = mutableListOf<MyModel>()

    private lateinit var myRecyclerAdapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "MainActivity - onCreate() called")

        Log.d(TAG, "MainActivity - list에 넣기 전 this.modleList.size : ${this.modelList.size}")

        for (i in 1..10){
            var myModel = MyModel(name = "User ${i}")
            this.modelList.add(myModel)
        }

        Log.d(TAG, "MainActivity - list에 넣은 후 this.modleList.size : ${this.modelList.size}")

        // 어댑터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerViewAdapter(this)

        myRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정
        main_activity_recyclerview.apply {
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            // 어댑터 장착
            adapter = myRecyclerAdapter
        }

    }

    override fun onItemClicked(position: Int) {
        Log.d(TAG, "MainActivity - onItemClicked() called / position : ${position}")

        var name: String? = null

        // 값이 비어있으면 "" 넣음
        // unwrapping - 언랩핑
        val title: String = this.modelList[position].name ?: ""

        Toast.makeText(this, "${position}이 눌렸습니다.", Toast.LENGTH_SHORT).show()

    }
}