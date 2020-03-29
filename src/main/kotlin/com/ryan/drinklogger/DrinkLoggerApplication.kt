package com.ryan.drinklogger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DrinkLoggerApplication

fun main(args: Array<String>) {
	runApplication<DrinkLoggerApplication>(*args)
}
