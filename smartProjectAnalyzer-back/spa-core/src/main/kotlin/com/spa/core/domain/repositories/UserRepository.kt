package com.spa.core.domain.repositories

import com.spa.core.domain.models.User
import com.spa.core.domain.repositories.contracts.CrudRepository

interface UserRepository: CrudRepository<User> {
    suspend fun findByEmail(email: String): User?
}