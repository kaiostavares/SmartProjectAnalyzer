package com.spa.core.domain.service

import com.spa.core.domain.enums.AccessLevelType
import com.spa.core.domain.exceptions.InternalServerException
import com.spa.core.domain.exceptions.ResourceAlreadyExistsException
import com.spa.core.domain.models.User
import com.spa.core.domain.models.valueObjects.Email
import com.spa.core.domain.models.valueObjects.EncryptedPassword
import com.spa.core.domain.repositories.AccessLevelRepository
import com.spa.core.domain.repositories.UserRepository
import java.util.*

class UserCreationDomainService(
    private val userRepository: UserRepository,
    private val accessLevelRepository: AccessLevelRepository
) {
    suspend fun createNewUser(id: UUID, name: String, email: Email, password: EncryptedPassword) : User {
        val accessLevel = accessLevelRepository.findByName(AccessLevelType.USER.name)
            ?: throw InternalServerException("User access not created in database")
        verifyIfUserExists(email)
        val newUser = User(
            id = id,
            name = name,
            email = email,
            accessLevel = accessLevel,
            password = password
        )
        userRepository.saveSafely(newUser).onFailure {
            throw InternalServerException("Error saving user: ${it.message}", it)
        }
        return newUser
    }

    private suspend fun verifyIfUserExists(email: Email) {
        userRepository.findByEmail(email.value)?.let {
            throw ResourceAlreadyExistsException("User with email ${email.value} already exists")
        }
    }

}