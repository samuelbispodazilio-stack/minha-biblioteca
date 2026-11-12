package com.example.minhabiblioteca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.minhabiblioteca.model.Livro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    livros: List<Livro>,
    onAbrir: (Int) -> Unit,
    onCadastro: () -> Unit,
    onSobre: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Minha Biblioteca") },
                actions = { TextButton(onClick = onSobre) { Text("Sobre") } }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = onCadastro) { Text("Novo livro") }
        }
    ) { inner ->
        LazyColumn(
            modifier = Modifier.padding(inner).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(livros, key = { it.id }) { livro ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(livro.titulo, style = MaterialTheme.typography.titleMedium)
                            Text("${livro.autor} • ${livro.ano}")
                        }
                        Button(onClick = { onAbrir(livro.id) }) { Text("Detalhes") }
                    }
                }
            }
        }
    }
}

