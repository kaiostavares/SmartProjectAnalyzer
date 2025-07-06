package com.spa.core.application.gateways

interface TransactionManagerGateway {
    suspend fun <T> doInTransaction(action: suspend () -> T ): T
}