package com.fumagalli.gerenciamento_tarefas.controllers;

import com.fumagalli.gerenciamento_tarefas.models.TarefaModel;
import com.fumagalli.gerenciamento_tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll(){
        List<TarefaModel> requeste = tarefaService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel){
        TarefaModel novo = tarefaService.criarTarefa(tarefaModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa (@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscarPorIdTarefa(@PathVariable Long id){
        Optional<TarefaModel> tarefa = tarefaService.buscarPorId(id);

        if(tarefa.isPresent()){
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel){
        TarefaModel atualizado = tarefaService.atualizar(id, tarefaModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
