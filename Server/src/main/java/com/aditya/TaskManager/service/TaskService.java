package com.aditya.TaskManager.service;

import com.aditya.TaskManager.dto.Response;
import com.aditya.TaskManager.dto.TaskRequest;
import com.aditya.TaskManager.entity.Task;

import java.util.List;

public interface TaskService {
    Response<Task> createTask(TaskRequest taskRequest);
    Response<List<Task>> getAllMyTasks();
    Response<Task> getTaskById(Long id);
    Response<Task> updateTask(TaskRequest taskRequest);
    Response<Void> deleteTask(Long id);
    Response<List<Task>> getMyTasksByCompletionStatus(boolean completed);
    Response<List<Task>> getMyTasksByPriority(String priority);
}
