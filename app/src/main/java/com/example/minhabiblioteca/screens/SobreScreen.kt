package com.example.minhabiblioteca.screens

import android.content.ActivityNotFoundException
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreScreen(onVoltar: () -> Unit) {
    val context = LocalContext.current

    Scaffold(topBar = { TopAppBar(title = { Text("Sobre / Ajuda") }) }) { inner ->
        Column(
            modifier = Modifier.padding(inner).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Minha Biblioteca", style = MaterialTheme.typography.headlineSmall)
            Text("Finalidade: organizar os livros que você leu ou quer ler.")
            Text("Como usar: toque em \"Novo livro\" para cadastrar e em \"Detalhes\" para consultar um item.")
            Text("Autor: Samuel Bispo dos Santos Dazilio")

            Button(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Conheça o app Minha Biblioteca, feito em Kotlin + Jetpack Compose para organizar seus livros."
                    )
                }
                try {
                    context.startActivity(Intent.createChooser(intent, "Compartilhar aplicativo"))
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(context, "Nenhum aplicativo disponível para compartilhar", Toast.LENGTH_SHORT).show()
                }
            }) { Text("Compartilhar aplicativo") }

            OutlinedButton(onClick = onVoltar) { Text("Voltar") }
        }
    }
}