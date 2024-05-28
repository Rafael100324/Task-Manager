package br.com.carlos.rafael.lista_tarefa_compose.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.carlos.rafael.lista_tarefa_compose.components.Botao
import br.com.carlos.rafael.lista_tarefa_compose.components.CaixaDeTexto
import br.com.carlos.rafael.lista_tarefa_compose.constantes.constantes
import br.com.carlos.rafael.lista_tarefa_compose.repositorio.TarefasRepositorio
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarTarefa(
    navController: NavController
){

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val tarefasRepositorio = TarefasRepositorio()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple80,
                title = {
                    Text(text = "Salvar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                        )
                }
            )
        }
    ){

        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarefa by remember {
            mutableStateOf("")
        }

        var semPrioridadeTarefa by remember {
            mutableStateOf(false)
        }

        var PrioridadeBaixaTarefa by remember {
            mutableStateOf(false)
        }

        var PrioridadeMediaTarefa by remember {
            mutableStateOf(false)
        }

        var PrioridadeAltaTarefa by remember {
            mutableStateOf(false)
        }

       Column (
           modifier = Modifier
               .fillMaxSize()
               .verticalScroll(rememberScrollState())
       ){
            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier.fillMaxWidth().padding(20.dp,20.dp,20.dp,0.dp),
                label = "Titulo Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )
           CaixaDeTexto(
               value = descricaoTarefa,
               onValueChange = {
                   descricaoTarefa = it
               },
               modifier = Modifier.fillMaxWidth().height(150.dp)
                   .padding(20.dp,10.dp,20.dp,0.dp),
               label = "Descrição",
               maxLines = 5,
               keyboardType = KeyboardType.Text
           )

           Row (
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Center,
               modifier = Modifier.fillMaxWidth()
           ){
               Text(text = "Nível de prioridade")

               RadioButton(
                   selected = PrioridadeBaixaTarefa,
                   onClick = {
                        PrioridadeBaixaTarefa = !PrioridadeBaixaTarefa
                   },
                   colors = RadioButtonDefaults.colors(
                       unselectedColor = RADIO_BUTTON_GREEN_DISABLED,
                       selectedColor = RADIO_BUTTON_GREEN_SELECTED
                   )
               )

               RadioButton(
                   selected = PrioridadeMediaTarefa,
                   onClick = {
                       PrioridadeMediaTarefa = !PrioridadeMediaTarefa
                   },
                   colors = RadioButtonDefaults.colors(
                       unselectedColor = RADIO_BUTTON_YELLOW_DISABLED,
                       selectedColor = RADIO_BUTTON_YELLOW_SELECTED
                   )
               )

               RadioButton(
                   selected = PrioridadeAltaTarefa,
                   onClick = {
                       PrioridadeAltaTarefa = !PrioridadeAltaTarefa
                   },
                   colors = RadioButtonDefaults.colors(
                       unselectedColor = RADIO_BUTTON_RED_DISABLED,
                       selectedColor = RADIO_BUTTON_RED_SELECTED
                   )
               )
           }

           Botao(
               onClick = {

                   var mensagem = true

                    scope.launch(Dispatchers.IO){
                        if (tituloTarefa.isEmpty()){
                            mensagem = false
                        }else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && PrioridadeBaixaTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.PRIORIDADE_BAIXA)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && PrioridadeMediaTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.PRIORIDADE_MEDIA)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && PrioridadeAltaTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.PRIORIDADE_ALTA)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && semPrioridadeTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.SEM_PRIORIDADE)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty()&& PrioridadeBaixaTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.PRIORIDADE_BAIXA)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty()&& PrioridadeMediaTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.PRIORIDADE_MEDIA)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty()&& PrioridadeAltaTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.PRIORIDADE_ALTA)
                            mensagem = true
                        }else{
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa, constantes.SEM_PRIORIDADE)
                            mensagem = true
                        }
                    }
                   scope.launch(Dispatchers.Main) {
                       if (mensagem) {
                           Toast.makeText(context, "Sucesso ao salvar a tarefa", Toast.LENGTH_SHORT).show()
                           navController.popBackStack()
                       } else {
                           Toast.makeText(context, "Título da tarefa é obrigatório", Toast.LENGTH_SHORT).show()
                       }
                   }
               },
               modifier = Modifier.fillMaxWidth().height(80.dp).padding(20.dp),
               texto = "Salvar"
           )
       }
    }
}