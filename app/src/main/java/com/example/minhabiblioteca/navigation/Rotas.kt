package com.example.minhabiblioteca.navigation

object Rotas {
    const val HOME = "home"
    const val CADASTRO = "cadastro"
    const val DETALHES = "detalhes/{id}"
    const val SOBRE = "sobre"

    // Monta a rota real, ex.: detalhes/2
    fun detalhes(id: Int) = "detalhes/$id"
}