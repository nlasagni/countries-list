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

/**
 * The repository of [Country].
 *
 * It is capable of getting countries and filtering by language or region.
 *
 * Created by Nicola Lasagni on 20/08/2021.
 */
interface CountryRepository {

    /**
     * Gests all countries in the repository.
     */
    suspend fun getAllCountries(): List<Country>

    /**
     * Gets a specific country that has the same [code] as the one specified.
     */
    suspend fun getCountryByCode(code: String): Country?

    /**
     * Filters the list of countries of the repository by language or region, using the [keyword]
     * specified.
     */
    suspend fun filterByLanguageOrRegion(keyword: String): List<Country>

}