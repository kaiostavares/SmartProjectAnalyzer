package com.spa.core.application.usecases

import com.spa.core.application.dtos.CreateUserCommand
import com.spa.core.application.dtos.UserOutput

interface CreateUserUseCase {
    suspend fun execute(command: CreateUserCommand): UserOutput
}