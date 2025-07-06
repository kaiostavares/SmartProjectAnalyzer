package com.spa.core.domain.repositories

import com.spa.core.domain.models.AccessLevel
import com.spa.core.domain.repositories.contracts.CrudRepository
import com.spa.core.domain.repositories.contracts.ReadOnlyRepository

interface AccessLevelRepository: ReadOnlyRepository<AccessLevel> {
    suspend fun findByName(name: String): AccessLevel?
}