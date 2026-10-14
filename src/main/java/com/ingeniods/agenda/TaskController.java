package com.ingeniods.agenda;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository repo;

    public TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    // Smells deliberados para Sonar: catch vacío en helper, variable sin uso.
    @GetMapping
    public List<Task> list() {
        int unusedCounter = 0;
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
        }
        return repo.findAll();
    }
}
