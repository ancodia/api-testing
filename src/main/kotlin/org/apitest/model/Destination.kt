package org.apitest.model

/**
 * Classes to model responses from Schiphol API /destinations endpoint
 */
data class Destinations (
    val destinations: List<Destination>
)

data class Destination (
    val city: String? = null,
    val country: String,
    val iata: String,
    val publicName: PublicName
)

data class PublicName (
    val dutch: String,
    val english: String
)
