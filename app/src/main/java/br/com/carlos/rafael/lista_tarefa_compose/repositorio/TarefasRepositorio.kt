package br.com.carlos.rafael.lista_tarefa_compose.repositorio

import br.com.carlos.rafael.lista_tarefa_compose.datasource.DataSource
import br.com.carlos.rafael.lista_tarefa_compose.model.Tarefa
import kotlinx.coroutines.flow.Flow


class TarefasRepositorio() {

    private val dataSource = DataSource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }
    fun recuperarTarefas(): Flow<MutableList<Tarefa>> {
        return dataSource.recuperarTarefas()
    }

    fun deletarTarefa(tarefa: String) {
        dataSource.deletarTarefa(tarefa)
    }
}