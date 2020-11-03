package com.android.practice.practice.customview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_benefit.*
import kotlinx.android.synthetic.main.benefit_view.*

class BenefitActivity : AppCompatActivity() {

    private val selectedItems: MutableList<String> = ArrayList()
    private var allItems: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benefit)
        var listView: ListView = findViewById(R.id.lv)
        var title: TextView = findViewById(R.id.et)
        send.setOnClickListener {
            val selectedString = et.text.trim().toString()

            when {
                selectedString.isEmpty() -> Toast.makeText(
                    this,
                    "Please Enter Data",
                    Toast.LENGTH_SHORT
                ).show()
                selectedItems.contains(selectedString) -> Toast.makeText(
                    this,
                    "Item Already Added",
                    Toast.LENGTH_SHORT
                ).show()
                else -> {
                    selectedItems.add(0, selectedString)
                    refreshData(true)
                }
            }
        }
    }

//    fun setTitle(title: String) {
//        this.title.text = title
//    }

    fun getSelectedData(): MutableList<String> {
        return selectedItems
    }

    fun refreshData(clearData: Boolean) {
        lv.adapter =
            MyCustomViewAdapter(this, R.layout.my_custom_view_item2, selectedItems)
        setListViewHeightBasedOnChildren(lv)
        if (clearData) et.setText("")
    }

    private fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter = listView.adapter ?: return
        var totalHeight = listView.paddingTop + listView.paddingBottom
        for (i in 0 until listAdapter.count) {
            val listItem = listAdapter.getView(i, null, listView)
            (listItem as? ViewGroup)?.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }
        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        listView.layoutParams = params
    }

    inner class MyCustomViewAdapter(
        context: Context,
        var resource: Int,
        var list: MutableList<String>
    ) :
        ArrayAdapter<String>(context, resource, list) {
        private val inflater = LayoutInflater.from(context)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = inflater.inflate(resource, parent, false)
            val name = view.findViewById<TextView>(R.id.name)
            val delete = view.findViewById<ImageView>(R.id.delete)
            name.text = list[position]
            delete.setOnClickListener {
                selectedItems.removeAt(position)
                refreshData(false)
            }
            return view
        }

        override fun getCount() = list.size
    }

}