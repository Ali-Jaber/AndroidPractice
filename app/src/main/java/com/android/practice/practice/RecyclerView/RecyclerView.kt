package com.android.practice.practice.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var myArrayList = ArrayList<User>()
        myArrayList.add(User("Elon Musk", R.drawable.person8, "38 minutes ago", R.drawable.post12))
        myArrayList.add(User("Test 1", R.drawable.person1, "38 minutes ago", R.drawable.post1))
        myArrayList.add(User("Test 2", R.drawable.person2, "38 minutes ago", R.drawable.post2))
        myArrayList.add(User("Test 3", R.drawable.person3, "38 minutes ago", R.drawable.post3))
        myArrayList.add(User("Test 4", R.drawable.person4, "38 minutes ago", R.drawable.post4))
        myArrayList.add(User("Test 5", R.drawable.person5, "38 minutes ago", R.drawable.post5))
        myArrayList.add(User("Test 6", R.drawable.person6, "38 minutes ago", R.drawable.post6))
        myArrayList.add(User("Test 7", R.drawable.person7, "38 minutes ago", R.drawable.post7))
        myArrayList.add(User("Test 8", R.drawable.person8, "38 minutes ago", R.drawable.post8))
        myArrayList.add(User("Test 9", R.drawable.person9, "38 minutes ago", R.drawable.post9))

        myRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val customAdapter = CustomAdapter(myArrayList)
        myRecyclerView.adapter = customAdapter
    }
}