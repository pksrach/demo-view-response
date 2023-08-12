package com.samrach.demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object JsonUtils {
    private var objectMapper: ObjectMapper? = null
    fun getObjectMapper(renew: Boolean = false): ObjectMapper {
        if (objectMapper == null || renew) {
            objectMapper = jacksonObjectMapper()
        }
        return objectMapper!!
    }
}