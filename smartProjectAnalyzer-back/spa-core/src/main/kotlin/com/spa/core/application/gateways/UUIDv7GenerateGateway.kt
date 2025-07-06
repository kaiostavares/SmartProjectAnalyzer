package com.spa.core.application.gateways

import java.util.UUID

interface UUIDv7GenerateGateway {
    fun generate(): UUID
}