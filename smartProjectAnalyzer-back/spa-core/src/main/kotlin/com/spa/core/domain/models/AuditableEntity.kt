package com.spa.core.domain.models

import com.spa.core.domain.exceptions.InternalServerException
import java.time.ZonedDateTime
import java.util.UUID

abstract class AuditableEntity: BaseEntity{
    val createdAt: ZonedDateTime
    var updatedAt: ZonedDateTime private set
    var deleted: Boolean private set

    constructor(
        id: UUID,
        createdAt: ZonedDateTime,
        updatedAt: ZonedDateTime,
        deleted: Boolean
    ) : super(id) {
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        this.deleted = deleted
    }

    constructor(
        id: UUID
    ) : this(
        id,
        ZonedDateTime.now(),
        ZonedDateTime.now(),
        false
    )

    fun markAsUpdated() {
        updatedAt = ZonedDateTime.now()
    }

    fun markAsDeleted() {
        deleted = true
        markAsUpdated()
    }

    fun markAsRestored() {
        if (!deleted) {
            throw InternalServerException("Entity is not deleted, cannot restore.")
        }
        deleted = false
        markAsUpdated()
    }
}