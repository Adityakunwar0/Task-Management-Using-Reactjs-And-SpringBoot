package com.aditya.TaskManager.controller;

import com.aditya.TaskManager.dto.Response;
import com.aditya.TaskManager.dto.TaskRequest;
import com.aditya.TaskManager.entity.Task;
import com.aditya.TaskManager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor

public class TaskController {

    private final TaskService taskService;


    @PostMapping
    public ResponseEntity<Response<Task>> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        return ResponseEntity.ok(taskService.createTask(taskRequest));
    }

    @PutMapping
    public ResponseEntity<Response<Task>> updateTask(@RequestBody TaskRequest taskRequest) {
        return ResponseEntity.ok(taskService.updateTask(taskRequest));
    }

    @GetMapping
    public ResponseEntity<Response<List<Task>>> getAllMyTasks() {
        return ResponseEntity.ok(taskService.getAllMyTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Task>> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }


    @GetMapping("/status")
    public ResponseEntity<Response<List<Task>>> getMyTasksByCompletionStatus(
            @RequestParam boolean completed
    ) {
        return ResponseEntity.ok(taskService.getMyTasksByCompletionStatus(completed));
    }

    @GetMapping("/priority")
    public ResponseEntity<Response<List<Task>>> getMyTasksByPriority(
            @RequestParam String priority
    ) {
        return ResponseEntity.ok(taskService.getMyTasksByPriority(priority));
    }

}
