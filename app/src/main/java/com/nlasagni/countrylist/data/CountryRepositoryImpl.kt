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

package com.nlasagni.countrylist.data

import android.util.Log
import com.nlasagni.countrylist.api.CountryFlagImageUrlService
import com.nlasagni.countrylist.api.RestCountriesService
import javax.inject.Inject

/**
 * Created by Nicola Lasagni on 16/08/2021.
 */
class CountryRepositoryImpl @Inject constructor(
    private val service: RestCountriesService,
    private val countryFlagImageUrlService: CountryFlagImageUrlService,
    private val countryCache: CountryCache
) : CountryRepository {

    override suspend fun getAllCountries(): Collection<Country> {
        val cached = countryCache.get()
        if (cached != null) {
            return cached
        }
        val countries = service.fetchAllCountries().map { country ->
            country.copy(
                flag = countryFlagImageUrlService.fetchFlagImageUrl(CountryCode(country.code))
            )
        }
        countryCache.put(countries)
        return countries
    }

    override suspend fun getCountryByCode(code: String): Country? {
        return getAllCountries().firstOrNull { it.code == code }
    }

    override suspend fun filterByLanguageOrRegion(keyword: String): Collection<Country> {
        Log.e("CountryRepositoryImpl", "filterByLanguageOrRegion: $keyword")
        return getAllCountries().filter {
            it.region.equals(keyword, ignoreCase = true) ||
                    it.languages.any { language -> language.name.equals(keyword, ignoreCase = true) }
        }
    }

}