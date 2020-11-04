package com.android.practice.practice.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.practice.practice.R

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    private var postsList = ArrayList<Post>()


    fun setList(list: List<Post>) {
        postsList= (list as ArrayList<Post>)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
    )


    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.titleTv.text = postsList[position].title
        holder.bodyTv.text = postsList[position].body
    }

    override fun getItemCount(): Int = postsList.size

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv: TextView = itemView.findViewById(R.id.item_title_textView)
        val bodyTv: TextView = itemView.findViewById(R.id.item_body_textView)
    }
}