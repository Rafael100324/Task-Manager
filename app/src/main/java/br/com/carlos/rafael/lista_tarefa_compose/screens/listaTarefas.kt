package br.com.carlos.rafael.lista_tarefa_compose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.carlos.rafael.lista_tarefa_compose.R
import br.com.carlos.rafael.lista_tarefa_compose.itemlista.Tarefaitem
import br.com.carlos.rafael.lista_tarefa_compose.model.Tarefa
import br.com.carlos.rafael.lista_tarefa_compose.repositorio.TarefasRepositorio
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.BLACK
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.Purple80
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.WHITE
import com.google.firebase.Firebase

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listaTarefa(
    navController: NavController
){
    val tarefasRepositorio = TarefasRepositorio()
    val context = LocalContext.current

    Scaffold (
        topBar = {
            TopAppBar(
                backgroundColor = Purple80,
                title = {
                    Text(
                        text = "Lista de Tarefas",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = WHITE
                    )
                }
            )
        },
        backgroundColor = BLACK,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("SalvarTarefa")
                },
                backgroundColor = Purple80
            ){
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de salvar tarefa!"
                )
        }
        }
    ){
            val listaTarefas = tarefasRepositorio.recuperarTarefas().collectAsState(initial = mutableListOf()).value

        LazyColumn {
            itemsIndexed(listaTarefas){
                position,_, -> Tarefaitem(position = position,listaTarefas = listaTarefas, context = context, navController = navController)
            }
        }
    }
}