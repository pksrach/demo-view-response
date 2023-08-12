package com.samrach.demo

import com.fasterxml.jackson.annotation.JsonView


data class UserResponse(
    @JsonView(AdminView::class)
    var id: String? = null,
    @JsonView(CustomerView::class)
    var username: String? = null,
    @JsonView(AdminView::class)
    var password: String? = null,
    @JsonView(CustomerView::class)
    var userType: String? = null,
    @JsonView(AdminView::class)
    var role: String? = null,
) {
    companion object {
        fun fromEntity(model: UserModelStoreValue?): UserResponse? {
            model ?: return null

            return UserResponse(
                id = model.id,
                username = model.username,
                password = model.password,
                userType = model.userType,
                role = model.role,
            )
        }
    }
}
