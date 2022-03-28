package com.example.standort.model

data class UniItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val state: String,
    val web_pages: List<String>
)