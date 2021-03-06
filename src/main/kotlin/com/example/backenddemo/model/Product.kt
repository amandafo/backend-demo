package com.example.backenddemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Product (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val title: String = "",

    @get: NotBlank
    val price: Long = 0,

    @get: NotBlank
    val description: String = "",

    @get: NotBlank
    val category: String = "",

    @get: NotBlank
    val image: String = ""
)