package com.nlasagni.countrylist.ui

import androidx.recyclerview.widget.DiffUtil
import com.nlasagni.countrylist.viewmodel.model.CountryListItem

/**
 * Created by Nicola Lasagni on 20/08/2021.
 */
class CountryListItemDiffCallback : DiffUtil.ItemCallback<CountryListItem>() {
    override fun areItemsTheSame(oldItem: CountryListItem, newItem: CountryListItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CountryListItem, newItem: CountryListItem): Boolean {
        return oldItem == newItem
    }
}