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
import androidx.fragment.app.activityViewModels
import com.nlasagni.countrylist.R
import com.nlasagni.countrylist.viewmodel.CountryViewModel
import com.nlasagni.countrylist.viewmodel.model.CountryDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_detail.*

/**
 * Created by Nicola Lasagni on 20/08/2021.
 */
class CountryDetailFragment : Fragment() {

    private val viewModel: CountryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.country_detail, container, false)
        subscribeForUpdates()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCountryDetail()
    }

    private fun subscribeForUpdates() {
        viewModel.countryDetailLiveData.observe(viewLifecycleOwner) {
            renderViewModel(it)
        }
    }

    private fun renderViewModel(countryDetail: CountryDetail) {
        countryName.text = countryDetail.name
        countryCode.text = countryDetail.code
        countryCapital.text = countryDetail.capital
        countryLanguages.text = countryDetail.languages
        countryRegion.text = countryDetail.region
        countrySubregion.text = countryDetail.subRegion
        Picasso.get()
            .load(countryDetail.flagImageUrl)
            .error(R.mipmap.ic_launcher)
            .fit().centerCrop()
            .into(flagImage)
    }

}