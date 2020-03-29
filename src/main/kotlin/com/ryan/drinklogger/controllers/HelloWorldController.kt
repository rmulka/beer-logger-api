package com.ryan.drinklogger.controllers

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hi")
class HelloWorldController {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun sayHi() = ResponseEntity.ok("hi")
}