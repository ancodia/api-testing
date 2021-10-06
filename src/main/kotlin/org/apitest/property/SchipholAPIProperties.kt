package org.apitest.property

/**
 * Properties related to Schiphol API
 */
data class SchipholAPIProperties(
    val base_url: String,
    val accept: String,
    val app_id: String,
    val app_key: String,
    val resource_version: String
)