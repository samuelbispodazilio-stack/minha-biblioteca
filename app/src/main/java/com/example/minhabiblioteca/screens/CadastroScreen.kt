package com.example.minhabiblioteca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(
    onSalvar: (String, String, Int, String) -> Unit,
    onCancelar: () -> Unit
) {
    var titulo by rememberSaveable { mutableStateOf("") }
    var autor by rememberSaveable { mutableStateOf("") }
    var ano by rememberSaveable { mutableStateOf("") }
    var anotacao by rememberSaveable { mutableStateOf("") }
    var erroTitulo by rememberSaveable { mutableStateOf<String?>(null) }
    var erroAno by rememberSaveable { mutableStateOf<String?>(null) }

    Scaffold(topBar = { TopAppBar(title = { Text("Novo livro") }) }) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título *") },
                isError = erroTitulo != null,
                supportingText = { erroTitulo?.let { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = autor,
                onValueChange = { autor = it },
                label = { Text("Autor") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = ano,
                onValueChange = { ano = it },
                label = { Text("Ano de publicação") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = erroAno != null,
                supportingText = { erroAno?.let { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = anotacao,
                onValueChange = { anotacao = it },
                label = { Text("Anotação") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = {
                    val anoInt = ano.toIntOrNull()
                    erroTitulo = if (titulo.isBlank()) "Informe o título" else null
                    erroAno = if (anoInt == null || anoInt <= 0)
                        "Informe um ano válido (número positivo)" else null

                    if (erroTitulo == null && erroAno == null) {
                        onSalvar(titulo.trim(), autor.trim(), anoInt!!, anotacao.trim())
                    }
                }) { Text("Salvar") }

                OutlinedButton(onClick = onCancelar) { Text("Cancelar") }
            }
        }
    }
}