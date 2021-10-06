package org.apitest.helpers

import org.apitest.property.SchipholAPIProperties

/**
 * Class containing methods to return configuration parameters
 */
open class ConfigurationSpecification {

    companion object {

        /**
         * Initialise schipholAPIProperties to map the configuration parameters in `resources/schiphol_config.yaml`
         */
        private val schipholAPIProperties: SchipholAPIProperties

        init {
            val inputStream = ConfigurationSpecification::class.java.getResourceAsStream("/schiphol_config.yaml")
            schipholAPIProperties = ObjectMapperHelper.yamlObjectMapper.readValue(inputStream, SchipholAPIProperties::class.java)
        }

        /**
         * Methods to return configuration parameters
         */
        fun getBaseUrl(): String {
            return schipholAPIProperties.base_url
        }

        fun getAcceptType(): String {
            return schipholAPIProperties.accept
        }

        fun getAppID(): String {
            return schipholAPIProperties.app_id
        }

        fun getAPPKey(): String {
            return schipholAPIProperties.app_key
        }

        fun getResourceVersion(): String {
            return schipholAPIProperties.resource_version
        }

    }
}
