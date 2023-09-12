package com.machinesoftware.intelligentvampire.ui.rest.controller;

import com.machinesoftware.intelligentvampire.domain.model.Task;
import com.machinesoftware.intelligentvampire.domain.servie.TaskService;
import com.machinesoftware.intelligentvampire.ui.dto.TaskDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("create")
    public ResponseEntity<TaskDTO> create(@RequestBody @Valid TaskDTO payload) {
        Task task = service.create(payload);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(task.getId())
                .toUri();
        return ResponseEntity.created(location).body(service.toDTO(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Integer id, @RequestBody @Valid TaskDTO payload) {
        if (Boolean.FALSE.equals(service.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        TaskDTO task = service.update(id, payload);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Integer id) {
        if (Boolean.FALSE.equals(service.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/completed/{id}")
    public ResponseEntity<TaskDTO> compelted(@PathVariable Integer id) {
        if (Boolean.FALSE.equals(service.completed(id))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (Boolean.FALSE.equals(service.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
