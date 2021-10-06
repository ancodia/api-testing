package org.apitest.helpers

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.specification.RequestSpecification


open class SchipholAPI : TestBase() {

    companion object {

        const val FLIGHTS_ENDPOINT = "/flights"
        const val DESTINATIONS_ENDPOINT = "/destinations"

        /**
         * Send GET request to a given `endpoint`
         */
        fun getRequest(specification: RequestSpecification,
                       endpoint: String,
                       expectedStatus: Int): String? {
            return Given {
                spec(specification)
            } When {
                get(endpoint)
            } Then {
                statusCode(expectedStatus)
            } Extract {
                body().asString()
            }
        }
    }

}