package com.example.retrofit_mvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_mvvm.service.api.ApiModel
import com.example.retrofit_mvvm.service.api.Datum

/**
 * Created by Taiyab Ali on 14-Jan-20.
 */

class PostAdapter(private val context: Context) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private lateinit var postList: ApiModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.post_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(postList.data[position])
    }

    override fun getItemCount(): Int {
        return postList.data.size
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.post_name)
        val post_description = itemView.findViewById<TextView>(R.id.post_description)
        val post_address = itemView.findViewById<TextView>(R.id.post_address)

        fun bindView(apiModel: Datum) {
            name.text = apiModel.name
            post_description.text = apiModel.description
            post_address.text = apiModel.address
        }

        //        val id: TextView = itemView.findViewById(R.id.post_id)

//        val body: TextView = itemView.findViewById(R.id.post_body)
    }

    fun setPostData(postList: ApiModel) {
        this.postList = postList
        notifyDataSetChanged()
    }


}