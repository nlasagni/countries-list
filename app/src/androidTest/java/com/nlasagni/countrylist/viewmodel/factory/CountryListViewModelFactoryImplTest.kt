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

package com.nlasagni.countrylist.viewmodel.factory

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.nlasagni.countrylist.MockData
import com.nlasagni.countrylist.R
import com.nlasagni.countrylist.viewmodel.model.CountryList
import com.nlasagni.countrylist.viewmodel.model.CountryListItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Nicola Lasagni on 20/08/2021.
 */
@RunWith(AndroidJUnit4::class)
class CountryListViewModelFactoryImplTest {

    lateinit var context: Context
    lateinit var viewModelFactory: CountryListViewModelFactory
    val countryListItems = listOf(
        CountryListItem(
            name = MockData.country.name,
            code = MockData.country.code,
            imageUrl = MockData.country.flag
        )
    )

    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        viewModelFactory = CountryListViewModelFactoryImpl(context)
    }

    @Test
    fun testModelCreation() {
        val emptyMessage = context.getString(R.string.no_country_available)
        val expected = CountryList(countryListItems, emptyMessage)
        Assert.assertEquals(
            expected,
            viewModelFactory.createModel(MockData.countryList, fromSearch = false)
        )
    }

    @Test
    fun testModelCreationFromSearch() {
        val emptyMessage = context.getString(R.string.no_search_result)
        val expected = CountryList(countryListItems, emptyMessage)
        Assert.assertEquals(
            expected,
            viewModelFactory.createModel(MockData.countryList, fromSearch = true)
        )
    }

}