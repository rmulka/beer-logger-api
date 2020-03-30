package com.ryan.drinklogger.models.db

import javax.persistence.*

@Entity
@Table(name = "beers")
data class Beer (

        @Id
        @Column(name = "id")
        var id: Int,

        @Column(name = "name")
        var name: String,

        @Column(name = "brewer")
        var brewer: String?,

        @Column(name = "style")
        var style: String?,

        @Column(name = "category")
        var category: String?,

        @Column(name = "city")
        var city: String?,

        @Column(name = "state")
        var state: String?,

        @Column(name = "country")
        var country: String?,

        @Column(name = "website")
        var website: String?,

        @Column(name = "abv")
        var abv: String?,

        @Column(name = "ibu")
        var ibu: String?,

        @Column(name = "description")
        var description: String?
)