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
    val marca: String = "",

    @get: NotBlank
    val name: String = "",

    @get: NotBlank
    val type: String = "",

    @get: NotBlank
    val cor: String = "",

    @get: NotBlank
    val size: Int? = null,

    @get: NotBlank
    val description: String = "",

    @get: NotBlank
    val photos: String = ""
)