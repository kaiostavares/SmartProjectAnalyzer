package com.spa.core.application.dtos

import com.spa.core.domain.enums.AccessLevelType
import com.spa.core.domain.models.User
import java.time.ZonedDateTime
import java.util.UUID

data class UserOutput(
    val id: UUID,
    val name: String,
    val email: String,
    val accessLevel: AccessLevelType,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime
){
    companion object{
        fun fromUser(user: User): UserOutput {
            return UserOutput(
                id = user.id,
                name = user.name,
                email = user.email.value,
                accessLevel = user.accessLevel.name,
                createdAt = user.createdAt,
                updatedAt = user.updatedAt
            )
        }

    }

}
