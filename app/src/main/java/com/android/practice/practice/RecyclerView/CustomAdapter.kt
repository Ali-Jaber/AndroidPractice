package com.android.practice.practice.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.practice.practice.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_list.view.*

class CustomAdapter(val myList: ArrayList<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val infoUser = myList[position]
        holder.username.text = infoUser.userName
        holder.timesAgo.text = infoUser.timeAgo
        holder.userPhoto.setImageResource(infoUser.userPhoto)
        holder.postPhoto.setImageResource(infoUser.postPhoto)

        holder.addPost.setOnClickListener {
            removeItem(position)
        }

        holder.addPost.setOnClickListener {
            addItem(position,infoUser)
        }
    }

    private fun addItem(position: Int, infoUser: User) {
        myList.add(position,infoUser)
        notifyItemInserted(position)
        notifyItemRangeChanged(position,myList.size)
    }

    private fun removeItem(position: Int) {
        myList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,myList.size)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username = itemView.findViewById<TextView>(R.id.username)
        val userPhoto = itemView.findViewById<CircleImageView>(R.id.userPhoto)
        val timesAgo = itemView.findViewById<TextView>(R.id.timesAgo)
        val postPhoto = itemView.findViewById<ImageView>(R.id.image_post)
        val addPost = itemView.findViewById<ImageButton>(R.id.addPost)
        val removePost = itemView.findViewById<ImageButton>(R.id.removePost)

    }
}