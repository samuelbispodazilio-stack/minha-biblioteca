package com.example.minhabiblioteca.model

data class Livro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val ano: Int,
    val anotacao: String
)