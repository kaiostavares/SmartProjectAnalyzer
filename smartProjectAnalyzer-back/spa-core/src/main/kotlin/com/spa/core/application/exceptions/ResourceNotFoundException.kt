package com.spa.core.application.exceptions

import com.spa.core.domain.exceptions.BusinessException

class ResourceNotFoundException: BusinessException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}