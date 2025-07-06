package com.spa.core.domain.models.valueObjects

import com.spa.core.domain.exceptions.InternalServerException
import com.spa.core.domain.exceptions.InvalidDataException

data class EncryptedPassword(val value: String){
    init {
        if(value.isEmpty()){
            throw InvalidDataException("Senha não pode ser vazia");
        }
        if(!value.matches(Regex("^\\$2[aby]\\$.{56}$"))){
            throw InternalServerException("Senha deve estar criptografada (BCrypt)")
        }
    }
}
