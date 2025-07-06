package com.spa.core.domain.models

import com.spa.core.domain.exceptions.InvalidDataException
import com.spa.core.domain.models.valueObjects.Email
import com.spa.core.domain.models.valueObjects.EncryptedPassword
import java.time.ZonedDateTime
import java.util.UUID

class User: AuditableEntity{
    var name: String private set
    var email: Email private set
    var accessLevel: AccessLevel private set
    var password: EncryptedPassword private set

    constructor(
        id: UUID,
        name: String,
        email: Email,
        accessLevel: AccessLevel,
        password: EncryptedPassword,
        createdAt: ZonedDateTime,
        updatedAt: ZonedDateTime,
        deleted: Boolean
    ) : super(id, createdAt, updatedAt, deleted) {
        this.name = name
        this.email = email
        this.accessLevel = accessLevel
        this.password = password
        validateName(name)
    }

    constructor(
        id: UUID,
        name: String,
        email: Email,
        accessLevel: AccessLevel,
        password: EncryptedPassword
    ) : super(id){
        this.name = name
        this.email = email
        this.accessLevel = accessLevel
        this.password = password
        validateName(name)
    }

    private fun validateName(name: String) {
        if (name.isEmpty()) {
            throw InvalidDataException("Nome não pode ser vazio")
        }
        if (name.length > 100) {
            throw InvalidDataException("Nome não pode ter mais de 100 caracteres")
        }
    }

}