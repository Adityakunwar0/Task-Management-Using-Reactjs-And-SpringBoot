package com.aditya.TaskManager.repository;

import com.aditya.TaskManager.entity.Task;
import com.aditya.TaskManager.entity.User;
import com.aditya.TaskManager.enums.Priority;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user, Sort sort);
    List<Task> findByCompletedAndUser(boolean completed, User user);
    List<Task> findByPriorityAndUser(Priority priority, User user, Sort sort);

}
