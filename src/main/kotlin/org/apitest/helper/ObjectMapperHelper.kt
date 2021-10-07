package org.apitest.helper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

object ObjectMapperHelper {

    val yamlObjectMapper = ObjectMapper(YAMLFactory())
        .registerKotlinModule()

}
