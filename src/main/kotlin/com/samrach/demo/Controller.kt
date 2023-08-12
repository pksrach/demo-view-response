package com.samrach.demo

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class Controller {
    @GetMapping("/admin")
    fun getAdmin(): ResponseEntity<JsonNode> {
        val userModel = UserModelStoreValue(
            id = "123",
            username = "john_doe",
            password = "password123",
            userType = "user",
            role = "admin",
        )
        val view = ViewController.withView(
            JsonUtils.getObjectMapper(),
            UserResponse.fromEntity(userModel),
            AdminView::class.java
        )

        return ResponseEntity.ok(view)
    }

    @GetMapping("/customer")
    fun getCustomer(): ResponseEntity<JsonNode> {
        val userModel = UserModelStoreValue(
            id = "321",
            username = "john_red",
            password = "123",
            userType = "user",
            role = "customer",
        )
        val view = ViewController.withView(
            mapper = JsonUtils.getObjectMapper(),
            data = UserResponse.fromEntity(userModel),
            viewClazz = CustomerView::class.java,
        )

        return ResponseEntity.ok(view)
    }

    @GetMapping("/supplier")
    fun getSupplier(): ResponseEntity<JsonNode> {
        val userModel = UserModelStoreValue(
            id = "321",
            username = "supplier_candy",
            password = "123456",
            userType = "user",
            role = "supplier",
        )

        val view = ViewController.withView(
            mapper = JsonUtils.getObjectMapper(),
            data = UserResponse.fromEntity(userModel),
            viewClazz = SupplierView::class.java,
        )

        return ResponseEntity.ok(view)
    }
}