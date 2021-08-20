package com.nlasagni.countrylist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nlasagni.countrylist.R
import com.nlasagni.countrylist.viewmodel.model.CountryListItem
import com.squareup.picasso.Picasso

/**
 * Created by Nicola Lasagni on 20/08/2021.
 */
class CountryListAdapter(
    private val itemClickListener: OnItemClickListener
) : ListAdapter<CountryListItem, CountryListAdapter.ViewHolder>(CountryListItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position, itemClickListener)
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var name: TextView = itemView.findViewById(R.id.countryName)
        private val image: ImageView = itemView.findViewById(R.id.countryImage)

        fun bind(countryListItem: CountryListItem, position: Int, itemClickListener: OnItemClickListener) {
            name.text = countryListItem.name
            Picasso.get()
                .load(countryListItem.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .fit().centerCrop()
                .into(image)
            view.setOnClickListener {
                itemClickListener.onItemClick(countryListItem, position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(countryListItem: CountryListItem, position: Int)
    }
}