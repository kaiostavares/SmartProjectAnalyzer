package com.spa.core.domain.repositories.contracts

import com.spa.core.domain.models.BaseEntity
import java.util.UUID

interface ReadOnlyRepository<T: BaseEntity> {
    suspend fun findById(id: UUID): T?
    suspend fun findAll(): List<T>
    suspend fun existsById(id: UUID): Boolean
}