package com.android.practice.practice.fragment.transferdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.practice.practice.R

class NameAdapter(val listener: OnItemClickListener) :
    RecyclerView.Adapter<NameAdapter.NameHolder>() {
    val names = ArrayList<Name>()

    fun addAll(names: List<Name>) {
        this.names.addAll(names)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_name_layout, parent, false)
        return NameHolder(view,listener)
    }

    override fun onBindViewHolder(holder: NameHolder, position: Int) {
        val name = names[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    class NameHolder(private val itemView: View,val listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                object : View.OnClickListener{
                    override fun onClick(v: View?) {
                        listener.onItemClick(name)
                    }

                }
            }
        }
        val tvName = itemView.findViewById<TextView>(R.id.custom_tv_name)
        lateinit var name: Name
        fun bind(name: Name) {
            this.name = name
            tvName.text = name.name
        }
    }
}