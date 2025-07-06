package com.spa.core.domain.exceptions

open class BusinessException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}