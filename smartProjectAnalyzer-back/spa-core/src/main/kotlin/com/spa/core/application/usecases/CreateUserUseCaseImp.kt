package com.spa.core.application.usecases

import com.spa.core.application.dtos.CreateUserCommand
import com.spa.core.application.dtos.UserOutput
import com.spa.core.application.gateways.PasswordEncoderGateway
import com.spa.core.application.gateways.TransactionManagerGateway
import com.spa.core.application.gateways.UUIDv7GenerateGateway
import com.spa.core.domain.exceptions.InternalServerException
import com.spa.core.domain.service.UserCreationDomainService


class CreateUserUseCaseImp(
    private val userCreationDomainService: UserCreationDomainService,
    private val passwordEncoder: PasswordEncoderGateway,
    private val transactionManager: TransactionManagerGateway,
    private val uuidV7Generate: UUIDv7GenerateGateway
) : CreateUserUseCase {

    override suspend fun execute(command: CreateUserCommand): UserOutput {
        return transactionManager.doInTransaction {
            val encodedPassword = passwordEncoder.encode(command.password)
            try {
                val newUser = userCreationDomainService.createNewUser(
                    id = uuidV7Generate.generate(),
                    name = command.name,
                    email = command.email,
                    password = encodedPassword
                )
                UserOutput.fromUser(newUser)
            }catch (e: InternalServerException){
                throw InternalServerException(
                    "Erro ao criar usuário, tente novamente mais tarde.", e
                )
            }
        }

    }
}