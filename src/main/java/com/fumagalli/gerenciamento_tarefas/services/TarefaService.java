package com.fumagalli.gerenciamento_tarefas.services;

import com.fumagalli.gerenciamento_tarefas.models.TarefaModel;
import com.fumagalli.gerenciamento_tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> findAll(){
        return tarefaRepository.findAll();
    }

    public TarefaModel criarTarefa(TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    public Optional<TarefaModel> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public TarefaModel atualizar(long id, TarefaModel tarefaModel){
        TarefaModel model = tarefaRepository.findById(id).get();
        model.setDescricao(tarefaModel.getDescricao());
        model.setDataVencimento(tarefaModel.getDataVencimento());
        model.setConcluida(tarefaModel.getConcluida());

        return tarefaRepository.save(model);
    }

    public void deletar(Long id){
        tarefaRepository.deleteById(id);
    }

}
