package com.example.task_meneger.controller;

import com.example.task_meneger.task.Task;
import com.example.task_meneger.task.TaskRepository;
import com.example.task_meneger.task.TaskRequestDTO;
import com.example.task_meneger.task.TaskResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody TaskRequestDTO data){
        Task taskData =  new Task(data);
        repository.save(taskData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<TaskResponseDTO> getAll(){

        List<TaskResponseDTO> taskList = repository.findAll().stream().map(TaskResponseDTO::new).toList();
        return taskList;
    }
}
