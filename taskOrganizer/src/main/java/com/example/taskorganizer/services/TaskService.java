package com.example.taskorganizer.services;

import com.example.taskorganizer.model.TaskModel;
import com.example.taskorganizer.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public class TaskService {

    final TaskRepository taskRepository;

    public TaskService(TaskRepository parkingSpotRepository) {
        this.taskRepository = parkingSpotRepository;
    }

    @Transactional
    public TaskModel save(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public Page<TaskModel> findAll(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    public Optional<TaskModel> findById(UUID id) {
        return taskRepository.findById(id);
    }



    @Transactional
    public void delete(TaskModel taskModel) {
        taskRepository.delete(taskModel);
    }
}
