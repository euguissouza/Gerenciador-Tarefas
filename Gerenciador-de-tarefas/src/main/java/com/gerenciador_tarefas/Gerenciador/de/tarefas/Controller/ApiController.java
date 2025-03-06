package com.gerenciador_tarefas.Gerenciador.de.tarefas.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/teste")
    public ResponseEntity<String> olaMundo(){
        return ResponseEntity.ok("Eu te amo meu amor todo");
    }


    @GetMapping("/tasks")
    public ResponseEntity<String> helloWorld() throws JsonProcessingException {
        return  ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(@RequestBody String tarefa){
        tasks.add(tarefa);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("/tasks")
    public ResponseEntity<Void> deleteTask(@RequestBody String tarefa) {
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }
}
