package br.com.carlos.rafael.lista_tarefa_compose.model

data class Tarefa(
    val tarefa: String? = null,
    val descricao: String? = null,
    val prioridade: Int? = null,
)