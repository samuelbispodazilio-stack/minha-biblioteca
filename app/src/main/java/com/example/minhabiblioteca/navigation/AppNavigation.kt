package com.example.minhabiblioteca.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.minhabiblioteca.data.LivroViewModel
import com.example.minhabiblioteca.screens.CadastroScreen
import com.example.minhabiblioteca.screens.DetalhesScreen
import com.example.minhabiblioteca.screens.HomeScreen
import com.example.minhabiblioteca.screens.SobreScreen

@Composable
fun AppNavigation(vm: LivroViewModel = viewModel()) {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Rotas.HOME) {

        composable(Rotas.HOME) {
            HomeScreen(
                livros = vm.livros,
                onAbrir = { id -> nav.navigate(Rotas.detalhes(id)) },
                onCadastro = { nav.navigate(Rotas.CADASTRO) },
                onSobre = { nav.navigate(Rotas.SOBRE) }
            )
        }

        composable(Rotas.CADASTRO) {
            CadastroScreen(
                onSalvar = { titulo, autor, ano, anotacao ->
                    vm.adicionar(titulo, autor, ano, anotacao)
                    nav.popBackStack()
                },
                onCancelar = { nav.popBackStack() }
            )
        }

        composable(
            route = Rotas.DETALHES,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { entry ->
            val id = entry.arguments?.getInt("id")
            DetalhesScreen(
                livro = id?.let { vm.buscar(it) },
                onVoltar = { nav.popBackStack() }
            )
        }

        composable(Rotas.SOBRE) {
            SobreScreen(onVoltar = { nav.popBackStack() })
        }
    }
}