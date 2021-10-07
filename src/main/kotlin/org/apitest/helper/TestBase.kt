package org.apitest.helper

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll

/**
 * Base class for Test classes
 */
open class TestBase {

    companion object {

        lateinit var requestSpecification: RequestSpecification

        /**
         * setup configuration
         */
        @BeforeAll
        @JvmStatic
        fun setup() {
            RestAssured.filters(RequestLoggingFilter(), ResponseLoggingFilter())
            requestSpecification = buildRequestSpecification()
        }

        /**
         * cleanup code
         */
        @AfterAll
        @JvmStatic
        fun cleanUp() {

        }

        /**
         * Build specification object for requests passing API url/path and headers
         */
        @JvmStatic
        fun buildRequestSpecification(baseUrl: String = "https://${ConfigurationSpecification.getBaseUrl()}",
                                      basePath: String = "/public-flights",
                                      acceptHeader: String =
                                          ConfigurationSpecification.getAcceptType(),
                                      appIdHeader: String =
                                          ConfigurationSpecification.getAppID(),
                                      appKeyHeader: String =
                                          ConfigurationSpecification.getAPPKey(),
                                      resourveVersionHeader: String =
                                          ConfigurationSpecification.getResourceVersion()): RequestSpecification {
            return RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(basePath)
                .addHeader(CommonConstants.Header.ACCEPT, acceptHeader)
                .addHeader(CommonConstants.Header.ID, appIdHeader)
                .addHeader(CommonConstants.Header.KEY, appKeyHeader)
                .addHeader(CommonConstants.Header.VERSION, resourveVersionHeader)
                .build()
        }
    }
}