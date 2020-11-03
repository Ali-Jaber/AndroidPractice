package com.android.practice.practice.recyclerview

import CustomAdapter
import ViewHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class UserRecyclerView : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initToolbar()
        val users = listOf(
            User("Elon Musk", R.drawable.person8, "38 minutes ago", R.drawable.post12),
            User("Test 1", R.drawable.person1, "38 minutes ago", R.drawable.post1),
            User("Test 2", R.drawable.person2, "38 minutes ago", R.drawable.post2),
            User("Test 3", R.drawable.person3, "38 minutes ago", R.drawable.post3),
            User("Test 4", R.drawable.person4, "38 minutes ago", R.drawable.post4),
            User("Test 5", R.drawable.person5, "38 minutes ago", R.drawable.post5),
            User("Test 6", R.drawable.person6, "38 minutes ago", R.drawable.post6),
            User("Test 7", R.drawable.person7, "38 minutes ago", R.drawable.post7),
            User("Test 8", R.drawable.person8, "38 minutes ago", R.drawable.post8),
            User("Test 9", R.drawable.person9, "38 minutes ago", R.drawable.post9),
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val customAdapter = object : CustomAdapter<User, ViewHolder>() {
            override fun createVm(parent: ViewGroup, viewType: Int): ViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
                return ViewHolder(view)
            }

            override fun bindVm(holder: ViewHolder, position: Int, item: User) {
                holder.username.text = item.userName
                holder.timesAgo.text = item.timeAgo
                holder.userPhoto.setImageResource(item.userPhoto)
                holder.postPhoto.setImageResource(item.postPhoto)
                holder.addPost.setOnClickListener {
                    removeItem(position)
                }
                holder.addPost.setOnClickListener {
                    addItem(position, item)
                }
                holder.removePost.setOnClickListener {
                    addItem(position, item)
                }
            }
        }
        myRecyclerView.adapter = customAdapter
        customAdapter.addAll(users)
    }
}