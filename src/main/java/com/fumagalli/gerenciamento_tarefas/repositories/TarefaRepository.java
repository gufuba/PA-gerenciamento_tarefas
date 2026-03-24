package com.fumagalli.gerenciamento_tarefas.repositories;

import com.fumagalli.gerenciamento_tarefas.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
