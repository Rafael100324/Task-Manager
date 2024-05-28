package br.com.carlos.rafael.lista_tarefa_compose.components

import android.service.autofill.OnClickAction
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.LIGHT_BLUE
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.WHITE

@Composable
fun Botao(
    onClick: () -> Unit,
    modifier: Modifier,
    texto : String
){
    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LIGHT_BLUE,
            contentColor = WHITE
        )
    ){
        Text(text = texto, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}
