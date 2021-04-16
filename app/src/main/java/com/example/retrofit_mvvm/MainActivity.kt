package com.example.retrofit_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_mvvm.service.api.ApiModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //    lateinit  -  it is promise to the compiler that value will be init in future
    private lateinit var postAdapter: PostAdapter
    lateinit var postViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        postViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        postViewModel.postApiData.observe(this, Observer {
            postAdapter.setPostData(it as ApiModel) // back on UI thread
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            Log.d("ABC", "onCreate: " + it)
        })
        postViewModel.getPost() // fetch on IO thread
    }

    private fun initRecyclerView() {

        postAdapter = PostAdapter(this)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
        var initData = ApiModel(false, "null", emptyList())
        postAdapter.setPostData(initData)
    }
}