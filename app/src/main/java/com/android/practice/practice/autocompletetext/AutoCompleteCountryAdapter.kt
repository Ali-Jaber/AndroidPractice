package com.android.practice.practice.autocompletetext

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.practice.practice.R

class AutoCompleteCountryAdapter(private val context: Context) : BaseAdapter(), Filterable {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val countryFull = ArrayList<CountryItem>()
    private val countrys = ArrayList<CountryItem>()

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val result = FilterResults()    
                val suggestions = ArrayList<CountryItem>()
                if (constraint == null || constraint.isEmpty()) {
                    suggestions.addAll(countryFull)
                } else {
                    val filterPattern = constraint.toString().trim()
                    val filteredCountry = countryFull.filter { countryItem ->
                        countryItem.countryName.contains(
                            filterPattern,
                            true
                        )
                    }
                    suggestions.addAll(filteredCountry)
                }
                result.values = suggestions
                result.count = suggestions.size
                return result
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countrys.clear()
                countrys.addAll(results?.values as List<CountryItem>)
                notifyDataSetChanged()
            }

            override fun convertResultToString(resultValue: Any?): CharSequence {
                return (resultValue as CountryItem).countryName
            }
        }
    }

    //    val countryFilter = object : Filter() {
//    }
    fun addAll(county: List<CountryItem>) {
        this.countryFull.addAll(county)
        this.countrys.addAll(county)
    }

    fun clear() {
        this.countrys.clear()
    }

    override fun getCount(): Int {
        return countrys.size
    }

    override fun getItem(position: Int): Any {
        return countrys[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val countryView: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            countryView = inflater.inflate(R.layout.country_autocomplete_row, parent, false)
            viewHolder = ViewHolder()
            viewHolder.flagName = countryView.findViewById(R.id.text_view_name)
            viewHolder.flagImage = countryView.findViewById(R.id.image_view_flag)
            countryView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            countryView = convertView
        }
        val country = countrys[position]
        val resourceId = context.resources.getIdentifier(
            country.flagImage.toString(),
            "drawable",
            context.packageName
        )
        viewHolder.flagName?.text = country.countryName
        viewHolder.flagImage?.setImageResource(resourceId)

        return countryView
    }

    private class ViewHolder {
        var flagName: TextView? = null
        var flagImage: ImageView? = null
    }
}