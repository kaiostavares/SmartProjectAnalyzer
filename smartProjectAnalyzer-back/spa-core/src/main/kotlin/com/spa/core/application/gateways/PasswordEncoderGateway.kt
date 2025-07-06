package com.spa.core.application.gateways

import com.spa.core.domain.models.valueObjects.EncryptedPassword
import com.spa.core.domain.models.valueObjects.Password

interface PasswordEncoderGateway {
    fun encode(password: Password): EncryptedPassword
    fun matches(password: Password, encryptedPassword: EncryptedPassword): Boolean
}