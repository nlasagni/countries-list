![Android CI status](https://github.com/nlasagni/countries-list/actions/workflows/android.yml/badge.svg)

# CountriesList Android app

## Introduction

The goal of this assignment is to create an app that allows you to obtain information about the 
countries of the world.  The application has to show a list of countries, from which you can access 
a detail screen of a single country where you can freely choose which information to show and how.
The list must be filterable by language or by continent. The filter can be an open search field or 
a selection from a list.

## Endpoint

To retrieve the data you can use these APIs:

- REST https://restcountries.eu
- GraphQL https://github.com/trevorblades/countries

It is possible to choose which of the two APIs to use.

## Technical constraints

- The app must support at least API 21.
- Pay particular attention to saving the status of the Activity or Fragment.
- The use of external libraries is allowed even if it must be adequately motivated (eg for the GraphQL API the use of Apollo is recommended).
- Presence of automated tests

## Project evaluation

In the evaluation phase, the technical choices and the cleanliness of the code will be considered with greater weight than the completeness of the app or the perfection of the UI (even if in any case we expect a clean and correct UI).

The app must still be usable by a user and therefore not crash, provide clear error messages when necessary and have adequate performance.

Are considered a plus:

- use of Kotlin (strongly recommended)
- use of the GraphQL API

The REST API returns country flags in SVG format. If the app plans to show them, we recommend that you take a look at https://www.countryflags.io/, an API that returns a flag in PNG format given its country code (example: https://www.countryflags.io/it/flat/64.png).
