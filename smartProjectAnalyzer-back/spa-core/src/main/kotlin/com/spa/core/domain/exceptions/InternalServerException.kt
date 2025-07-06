package com.spa.core.domain.exceptions

class InternalServerException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}