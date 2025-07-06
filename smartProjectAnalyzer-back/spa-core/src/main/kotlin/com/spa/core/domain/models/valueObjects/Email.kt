package com.spa.core.domain.models.valueObjects

import com.spa.core.domain.exceptions.InvalidDataException

data class Email(val value: String) {
    init {
        if(value.isBlank()){
            throw InvalidDataException("Email não pode ser vazio")
        }

        if(!EMAIL_FORMAT.matches(value)){
            throw InvalidDataException("Formato de email inválido")
        }
    }

    companion object {
        private val EMAIL_FORMAT = Regex("^[A-Za-z0-9+_.-]+@(.+)$")
    }
}
