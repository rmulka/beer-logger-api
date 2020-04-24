package com.ryan.drinklogger.services

import com.ryan.drinklogger.constants.*
import com.ryan.drinklogger.models.db.Beer
import com.ryan.drinklogger.repositories.BeerRepository
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class BeerService(private val beerRepository: BeerRepository) {

    fun findBeers(searchParams: Map<String, List<String>>): List<Beer> {
        val beersList: MutableList<Beer> = beerRepository.findAll()

        searchParams.forEach { (searchParam: String, paramValues: List<String>) ->
            when (searchParam) {
                NAME -> beersList.retainAll { it.name in paramValues }
                BREWER ->beersList.retainAll { it.brewer in paramValues }
                STYLE -> beersList.retainAll { it.style in paramValues }
                CATEGORY -> beersList.retainAll { it.category in paramValues }
                CITY -> beersList.retainAll { it.city in paramValues }
                STATE -> beersList.retainAll { it.state in paramValues }
                COUNTRY -> beersList.retainAll { it.country in paramValues }
                else -> throw IllegalStateException("$INVALID_SEARCH_PARAMETER $searchParam")
            }
        }

        return beersList
    }
}