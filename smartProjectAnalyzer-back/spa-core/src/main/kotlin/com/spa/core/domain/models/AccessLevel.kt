package com.spa.core.domain.models

import com.spa.core.domain.enums.AccessLevelType
import java.util.UUID

class AccessLevel(
    override val id: UUID,
    val name: AccessLevelType,
) : BaseEntity(id)