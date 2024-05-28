package br.com.carlos.rafael.lista_tarefa_compose.components

import androidx.compose.animation.core.keyframesWithSpline
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.BLACK
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.LIGHT_BLUE
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.ShapeEditText
import br.com.carlos.rafael.lista_tarefa_compose.ui.theme.WHITE

@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
)
{
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = BLACK,
            focusedBorderColor = LIGHT_BLUE,
            focusedLabelColor = LIGHT_BLUE,
            backgroundColor = WHITE,
            cursorColor = LIGHT_BLUE
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}
