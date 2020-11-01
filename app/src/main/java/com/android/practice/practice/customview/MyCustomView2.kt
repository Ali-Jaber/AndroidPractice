package com.android.practice.practice.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.practice.practice.R

class MyCustomView2(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var autoCompleteTextView: AutoCompleteTextView
    private var listView: ListView
    private var title: TextView
    private var add: ImageView

    private val selectedItems: MutableList<String> = ArrayList()
    private var allItems: MutableList<String> = ArrayList()

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.my_custom_view_layout2, this, true)
        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)
        listView = view.findViewById(R.id.listView)
        title = view.findViewById(R.id.title)
        add = view.findViewById(R.id.addTxt)
        autoCompleteTextView.threshold = 1

        add.setOnClickListener {
            val selectedString = autoCompleteTextView.text.trim().toString()

            when {
                selectedString.isEmpty() -> Toast.makeText(
                    context,
                    "Please Enter Data",
                    Toast.LENGTH_SHORT
                ).show()
                selectedItems.contains(selectedString) -> Toast.makeText(
                    context,
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

    fun setData(data: MutableList<String>) {
        allItems = data
        autoCompleteTextView.setAdapter(
            ArrayAdapter(
                context,
                android.R.layout.simple_list_item_1,
                allItems
            )
        )
    }

    fun setTitle(title: String) {
        this.title.text = title
    }

    fun getSelectedData(): MutableList<String> {
        return selectedItems
    }

    fun refreshData(clearData: Boolean) {
        listView.adapter =
            MyCustomViewAdapter(context, R.layout.my_custom_view_item2, selectedItems)
        setListViewHeightBasedOnChildren(listView)
        if (clearData) autoCompleteTextView.setText("")
    }

    private fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter = listView.adapter ?: return
        var totalHeight = listView.paddingTop + listView.paddingBottom
        for (i in 0 until listAdapter.count) {
            val listItem = listAdapter.getView(i, null, listView)
            (listItem as? ViewGroup)?.layoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
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