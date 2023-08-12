package com.samrach.demo

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

interface ViewController {
    companion object {
        fun withView(mapper: ObjectMapper, data: Any?, viewClazz: Class<*>): JsonNode {
            val node = mapper.writerWithView(viewClazz).writeValueAsString(data)
            return mapper.readTree(node)
        }
    }
}

interface CustomerView : ViewController
interface SupplierView : CustomerView
interface AdminView : SupplierView