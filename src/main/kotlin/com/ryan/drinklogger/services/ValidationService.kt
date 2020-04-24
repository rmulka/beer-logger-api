package com.ryan.drinklogger.services

import org.springframework.stereotype.Service
import com.ryan.drinklogger.constants.*
import com.ryan.drinklogger.utilities.validatePopulatedFields

@Service
class ValidationService {

    fun validateUserFields(user: HashMap<String, String?>): Boolean {
        return when {
            !validatePopulatedFields(userFields, user) -> false
            else -> true
        }
    }
}