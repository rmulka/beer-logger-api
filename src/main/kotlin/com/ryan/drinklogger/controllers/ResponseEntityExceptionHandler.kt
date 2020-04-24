package com.ryan.drinklogger.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.IllegalStateException

@ControllerAdvice
class RestResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(IllegalStateException::class)])
    fun handleIllegalStateException(ex: Exception, request: WebRequest)
            : ResponseEntity<Any> =
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)
}