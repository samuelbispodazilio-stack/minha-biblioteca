package com.example.minhabiblioteca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.minhabiblioteca.model.Livro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesScreen(livro: Livro?, onVoltar: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("Detalhes") }) }) { inner ->
        Column(
            modifier = Modifier.padding(inner).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (livro == null) {
                Text("Livro não encontrado.")
            } else {
                Text(livro.titulo, style = MaterialTheme.typography.headlineSmall)
                Text("Autor: ${livro.autor.ifBlank { "—" }}")
                Text("Ano: ${livro.ano}")
                Text("Anotação: ${livro.anotacao.ifBlank { "—" }}")
            }
            Button(onClick = onVoltar) { Text("Voltar") }
        }
    }
}