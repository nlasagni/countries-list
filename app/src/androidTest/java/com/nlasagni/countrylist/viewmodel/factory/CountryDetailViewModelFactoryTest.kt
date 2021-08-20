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
import com.nlasagni.countrylist.viewmodel.model.CountryDetail
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Nicola Lasagni on 20/08/2021.
 */
@RunWith(AndroidJUnit4::class)
class CountryDetailViewModelFactoryTest {

    lateinit var context: Context

    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun testModelCreation() {
        val viewModelFactory = CountryDetailViewModelFactoryImpl(context)
        val expected = CountryDetail(
            name = MockData.country.name,
            flagImageUrl = MockData.country.flag,
            code = context.getString(R.string.country_code, MockData.country.code),
            capital = context.getString(R.string.country_capital, MockData.country.capital),
            languages = context.getString(R.string.country_languages, MockData.countryLanguageName),
            region = context.getString(R.string.country_region, MockData.country.region),
            subRegion = context.getString(R.string.country_subregion, MockData.country.subRegion)
        )
        Assert.assertEquals(expected, viewModelFactory.createModel(MockData.country))
    }

}