package com.spa.core.domain.models

import java.util.UUID

abstract class BaseEntity(open val id: UUID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BaseEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}