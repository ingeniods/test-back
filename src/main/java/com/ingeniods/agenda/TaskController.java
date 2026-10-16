package com.ingeniods.agenda;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public Task create(@RequestBody TaskCreateRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDueDate(request.dueDate());
        task.setPriority(request.priority() == null ? TaskPriority.MEDIUM : request.priority());
        task.setCreatedAt(LocalDateTime.now());
        return repo.save(task);
    }
}
