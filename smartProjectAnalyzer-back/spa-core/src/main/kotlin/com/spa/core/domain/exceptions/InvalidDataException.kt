package com.spa.core.domain.exceptions

class InvalidDataException: BusinessException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}