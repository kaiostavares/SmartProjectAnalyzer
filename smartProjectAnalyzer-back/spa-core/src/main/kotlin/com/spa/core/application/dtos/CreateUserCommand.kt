package com.spa.core.application.dtos

import com.spa.core.domain.models.valueObjects.Email
import com.spa.core.domain.models.valueObjects.Password

data class CreateUserCommand(
    val name: String,
    val email: Email,
    val password: Password,
)
