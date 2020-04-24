package com.ryan.drinklogger.controllers

import com.ryan.drinklogger.constants.BEERS_URI
import com.ryan.drinklogger.models.db.Beer
import com.ryan.drinklogger.services.BeerService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(BEERS_URI)
@CrossOrigin(origins = ["http://localhost:3000"])
class BeerController(private val beerService: BeerService) {

    /**
     * GET beers endpoint
     *
     * See application constants for list of search parameter options
     */
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBeers(
            @RequestParam searchParams: MultiValueMap<String, String>
    ): ResponseEntity<List<Beer>> = ResponseEntity.ok(beerService.findBeers(searchParams))
}