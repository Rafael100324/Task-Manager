package br.com.carlos.rafael.lista_tarefa_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.carlos.rafael.lista_tarefa_compose.screens.SalvarTarefa
import br.com.carlos.rafael.lista_tarefa_compose.screens.listaTarefa
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.Lista_tarefa_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lista_tarefa_composeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,  startDestination = "listaTarefas") {
                    composable(
                        route = "listaTarefas",
                    ){
                        listaTarefa(navController)
                    }
                    composable(
                        route = "SalvarTarefa"
                    ){
                        SalvarTarefa(navController)
                    }
                }
            }
        }
    }
}

