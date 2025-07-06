package com.spa.core.domain.models.valueObjects

import com.spa.core.domain.exceptions.InvalidDataException

data class Password(val value: String) {
    init {
        if(value.isEmpty()){
            throw InvalidDataException("Senha não pode ser vazia");
        }
        if (value.length < 8) {
            throw  InvalidDataException("Senha deve ter pelo menos 8 caracteres");
        }
    }

}