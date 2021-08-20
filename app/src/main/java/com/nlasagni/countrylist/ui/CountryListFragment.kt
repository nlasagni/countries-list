/*
 * MIT License
 *
 * Copyright (c) 2021 Nicola Lasagni
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nlasagni.countrylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.nlasagni.countrylist.R
import com.nlasagni.countrylist.viewmodel.CountryListViewModel
import com.nlasagni.countrylist.viewmodel.model.CountryList
import com.nlasagni.countrylist.viewmodel.model.CountryListItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.country_list.*

/**
 * Created by Nicola Lasagni on 17/08/2021.
 */
@AndroidEntryPoint
class CountryListFragment : Fragment(), CountryListAdapter.OnItemClickListener {

    private val viewModel: CountryListViewModel by viewModels()
    private val adapter = CountryListAdapter(this)
    private val columnCount = 2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.country_list, container, false)
        subscribeForUpdates()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryList.layoutManager = GridLayoutManager(context, columnCount)
        countryList.adapter = adapter
    }

    private fun subscribeForUpdates() {
        viewModel.countryListLiveData.observe(viewLifecycleOwner) {
            renderViewModel(it)
        }
    }

    private fun renderViewModel(countryList: CountryList) {
        adapter.submitList(countryList.countries)
    }

    override fun onItemClick(countryListItem: CountryListItem, position: Int) {
        //TODO("Not yet implemented")
    }


}