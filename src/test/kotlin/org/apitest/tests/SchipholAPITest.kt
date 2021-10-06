package org.apitest.tests

import com.google.gson.Gson
import org.apache.http.HttpStatus
import org.apitest.model.Destinations
import org.apitest.model.Flights
import org.apitest.helpers.CommonConstants
import org.apitest.helpers.SchipholAPI
import org.apitest.model.Destination
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SchipholAPITest : SchipholAPI() {

    private val gson = Gson()

    @Test
    @Tags(Tag(CommonConstants.TestTag.SCHIPHOL))
    fun `Validate destination countries list`() {
        val body = getRequest(requestSpecification,
            DESTINATIONS_ENDPOINT,
            HttpStatus.SC_OK)
        // map JSON response to modelling data classes
        val destinations = gson.fromJson(body, Destinations::class.java).destinations
        // sort destinations by country
        val sortedDestinations: List<Destination> = destinations.sortedWith(compareBy { it.country })
        println("Sorted list of destination countries:")
        sortedDestinations.forEach { destination ->
            println(destination.country)
        }
        val country = "Australia"
        val city = "Sydney"
        // validate record exists for "city": "Sydney", "country": "Australia"
        val filteredDestinations = sortedDestinations.filter {
            it.country == country && it.city == city
        }

        assertTrue(filteredDestinations.isNotEmpty(), "Failed to find destination for ${country}-${city}")
    }

    @Test
    @Tags(Tag(CommonConstants.TestTag.SCHIPHOL))
    fun `Validate destination IATA and City`() {
        val body = getRequest(requestSpecification,
            DESTINATIONS_ENDPOINT,
            HttpStatus.SC_OK)
        val destinations = gson.fromJson(body, Destinations::class.java).destinations

        // validate record exists for "city": "Sydney", "country": "Australia"
        val filteredDestinations = destinations.filter {
            it.country == "Australia"
        }

        for (destination in filteredDestinations) {
            val iata = destination.iata
            val city: String? = destination.city
            assertTrue(iata.isNotEmpty(), "Failed to find IATA in $destination")
            assertTrue(!city.isNullOrEmpty(), "Failed to find city in $destination")
        }
    }

    @Test
    @Tags(Tag(CommonConstants.TestTag.SCHIPHOL))
    fun `Validate Flight IATA codes`() {
        val body = getRequest(requestSpecification,
            FLIGHTS_ENDPOINT,
            HttpStatus.SC_OK)
        val flights = gson.fromJson(body, Flights::class.java).flights

        // display flight details and check that IATA code is present
        flights.forEach { flight ->
            val prefixIATA = flight.prefixIATA
            val aircraftTypeIataMain = flight.aircraftType.iataMain
            val aircraftTypeIataSub = flight.aircraftType.iataSub
            val destination = flight.route.destinations
            val scheduleTime = flight.scheduleTime
            println("Flight details: $prefixIATA - $aircraftTypeIataMain - " +
                    "$aircraftTypeIataSub - $destination - $scheduleTime")
            assertTrue(prefixIATA.isNotEmpty(), "Failed to find IATA for $flight")
        }
    }

    @Test
    @Tags(Tag(CommonConstants.TestTag.SCHIPHOL))
    fun `Invalid API Key - Destinations`() {
        val specification = buildRequestSpecification(appKeyHeader = "asdfg12345")

        getRequest(specification,
            DESTINATIONS_ENDPOINT,
            HttpStatus.SC_FORBIDDEN)
    }
}