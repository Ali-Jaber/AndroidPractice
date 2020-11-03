package com.android.practice.practice.room

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.practice.practice.R

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewModel>() {

    private var postsList = ArrayList<Post>()


    fun setList(list: List<Post>) {
        postsList.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewModel {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PostsViewModel, position: Int) {
        holder.titleTv.text = postsList[position].title
        holder.bodyTv.text = postsList[position].body
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class PostsViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv = itemView.findViewById<TextView>(R.id.item_title_textView)
        val bodyTv = itemView.findViewById<TextView>(R.id.item_body_textView)
    }
}