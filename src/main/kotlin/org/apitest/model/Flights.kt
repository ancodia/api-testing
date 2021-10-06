package org.apitest.model

/**
 * Classes to model responses from Schiphol API /flights endpoint
 */
data class Flights (
    val flights: List<Flight>
)

data class Flight (
    val lastUpdatedAt: String,
    val actualLandingTime: String,
    val actualOffBlockTime: Any? = null,
    val aircraftRegistration: String,
    val aircraftType: AircraftType,
    val baggageClaim: BaggageClaim,
    val checkinAllocations: Any? = null,
    val codeshares: Codeshares? = null,
    val estimatedLandingTime: String,
    val expectedTimeBoarding: Any? = null,
    val expectedTimeGateClosing: Any? = null,
    val expectedTimeGateOpen: Any? = null,
    val expectedTimeOnBelt: String,
    val expectedSecurityFilter: Any? = null,
    val flightDirection: String,
    val flightName: String,
    val flightNumber: Long,
    val gate: String,
    val pier: String,
    val id: String,
    val isOperationalFlight: Boolean,
    val mainFlight: String,
    val prefixIATA: String,
    val prefixICAO: String,
    val airlineCode: Long,
    val publicEstimatedOffBlockTime: Any? = null,
    val publicFlightState: PublicFlightState,
    val route: Route,
    val scheduleDateTime: String,
    val scheduleDate: String,
    val scheduleTime: String,
    val serviceType: String,
    val terminal: Long,
    val transferPositions: Any? = null,
    val schemaVersion: String
)

data class AircraftType (
    val iataMain: String,
    val iataSub: String
)

data class BaggageClaim (
    val belts: List<String>
)

data class Codeshares (
    val codeshares: List<String>
)

data class PublicFlightState (
    val flightStates: List<String>
)

data class Route (
    val destinations: List<String>,
    val eu: String,
    val visa: Boolean
)

