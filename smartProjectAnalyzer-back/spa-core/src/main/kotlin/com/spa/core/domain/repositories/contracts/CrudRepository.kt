package com.spa.core.domain.repositories.contracts

import com.spa.core.domain.models.BaseEntity
import java.util.UUID

interface CrudRepository<T: BaseEntity> :
     SaveOnlyRepository<T>, ReadOnlyRepository<T>
{
     suspend fun delete(id: UUID): Boolean
}