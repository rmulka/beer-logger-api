package com.ryan.drinklogger.controllers

import com.ryan.drinklogger.constants.USERS_URI
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal


@RestController
@RequestMapping(USERS_URI)
class UsersController {

    @GetMapping
    fun getHi(): String {
        return "users controller says hi"
    }

//    @GetMapping
//    fun getPrincipal(principal: Principal): Principal? {
//        return principal
//    }
}