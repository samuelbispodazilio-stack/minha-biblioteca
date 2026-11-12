package com.example.minhabiblioteca.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.minhabiblioteca.model.Livro

class LivroViewModel : ViewModel() {

    // Lista observável: quando muda, o Compose redesenha as telas que a usam
    private val _livros = mutableStateListOf(
        Livro(1, "Dom Casmurro", "Machado de Assis", 1899, "Clássico brasileiro"),
        Livro(2, "O Cortiço", "Aluísio Azevedo", 1890, "Naturalismo"),
        Livro(3, "Capitães da Areia", "Jorge Amado", 1937, "Romance modernista")
    )

    // As telas só leem a lista; quem altera é o ViewModel
    val livros: List<Livro> get() = _livros

    // Próximo ID livre (os iniciais usam 1, 2 e 3)
    private var proximoId = 4

    fun adicionar(titulo: String, autor: String, ano: Int, anotacao: String) {
        _livros.add(Livro(proximoId, titulo, autor, ano, anotacao))
        proximoId++
    }

    fun buscar(id: Int): Livro? = _livros.find { it.id == id }
}