package org.apitest.helpers

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.ValidatableResponse
import io.restassured.specification.RequestSpecification
import org.apache.http.HttpStatus


open class SchipholAPI : TestBase() {

    companion object {

        const val FLIGHTS_ENDPOINT = "/flights"
        const val DESTINATIONS_ENDPOINT = "/destinations"

        /**
         * Set header for request
         */
        fun RequestSpecification.setHeaders(type: String,
                                            app_id: String,
                                            app_key: String,
                                            resource_version: String): RequestSpecification =
            header(CommonConstants.Header.ACCEPT, type).and()
                .header(CommonConstants.Header.ID, app_id).and()
                .header(CommonConstants.Header.KEY, app_key).and()
                .header(CommonConstants.Header.VERSION, resource_version)


        /**
         * Verify the response details
         */
        fun ValidatableResponse.validateResponseDetails(status: Int = HttpStatus.SC_OK): ValidatableResponse =
            statusCode(status)

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