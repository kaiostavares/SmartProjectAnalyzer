package com.spa.core.domain.repositories.contracts

import com.spa.core.domain.models.BaseEntity

interface SaveOnlyRepository<T: BaseEntity>{
    suspend fun save(entity: T): T
    suspend fun saveSafely(entity: T): Result<Unit>
}