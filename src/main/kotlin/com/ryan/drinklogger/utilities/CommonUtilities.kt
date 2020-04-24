package com.ryan.drinklogger.utilities

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.gson.Gson
import com.ryan.drinklogger.constants.IS_MISSING
import net.minidev.json.JSONObject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun validatePopulatedFields(stringArray: Array<String>, entityMap: HashMap<String, String?>): Boolean {
    stringArray.forEach {
        if (entityMap[it].isNullOrBlank()) {
            entityMap["error"] = "$it $IS_MISSING"
            return false
        }
    }
    return true
}