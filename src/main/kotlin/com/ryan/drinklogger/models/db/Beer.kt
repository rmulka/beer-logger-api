package com.ryan.drinklogger.models.db

import javax.persistence.*

@Entity
@Table(name = "beers")
data class Beer (

        @Id
        @Column(name = "id")
        val id: Int,

        @Column(name = "name")
        val name: String,

        @Column(name = "brewer")
        val brewer: String?,

        @Column(name = "style")
        val style: String?,

        @Column(name = "category")
        val category: String?,

        @Column(name = "city")
        val city: String?,

        @Column(name = "state")
        val state: String?,

        @Column(name = "country")
        val country: String?,

        @Column(name = "website")
        val website: String?,

        @Column(name = "abv")
        val abv: String?,

        @Column(name = "ibu")
        val ibu: String?,

        @Column(name = "description", length = 8192)
        val description: String?
)