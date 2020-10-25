package com.android.practice.practice.fragment.transferdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_main_transfer_fragment.*

class MainTransferFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_transfer_fragment)

        val names = listOf(
            Name("Ali"),
            Name("Ahmad"),
            Name("Mohammed"),
            Name("Tarek"),
        )

        main_rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val nameAdapter = NameAdapter(object : OnItemClickListener {
            override fun onItemClick(name: Name) {
                val fragment = NameFragment.instance(name.name)
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(R.id.main_fragment,fragment)
                ft.commit()

//                Toast.makeText(applicationContext, name.name, Toast.LENGTH_SHORT).show()
            }

        })
        nameAdapter.addAll(names)
        main_rv.adapter = nameAdapter
    }
}