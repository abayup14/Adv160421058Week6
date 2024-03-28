package com.example.adv160421058week6.model

data class Phone(
    val id: Int?,
    val brand: String?,
    val model: String?,
    val color: List<String>?,
    val specs: PhoneSpec?,
    val images: String?
)

data class PhoneSpec(
    val display: String?,
    val processor: String?,
    val RAM: String?,
    val storage: String?,
    val camera: String?
)