package com.ryan.drinklogger.repositories

import com.ryan.drinklogger.models.db.Beer
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface BeerRepository: JpaRepository<Beer, Int>