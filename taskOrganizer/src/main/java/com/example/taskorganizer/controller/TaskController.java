package com.example.taskorganizer.controller;

import com.example.taskorganizer.dtos.TaskDto;
import com.example.taskorganizer.model.TaskModel;
import com.example.taskorganizer.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

public class TaskController {

    final TaskService taskService;

    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Object> saveTask(@RequestBody @Valid TaskDto taskDto){



        var taskModel = new TaskModel();
        BeanUtils.copyProperties(taskDto,taskModel);
        taskModel.setStart_task(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskModel));
    }
    @GetMapping
    public ResponseEntity<Page<TaskModel>> getAllTasks(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTask(@PathVariable(value = "id") UUID id){
        Optional<TaskModel> parkingSpotModelOptional = taskService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") UUID id){
        Optional<TaskModel> parkingSpotModelOptional = taskService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        taskService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid TaskDto taskDto){
        Optional<TaskModel> TaskModelOptional = taskService.findById(id);
        if (!TaskModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        var taskModel = new TaskModel();
        BeanUtils.copyProperties(taskDto, taskModel);
        taskModel.setId(TaskModelOptional.get().getId());
        taskModel.setStart_task(TaskModelOptional.get().getStart_task());
        return ResponseEntity.status(HttpStatus.OK).body(taskService.save(taskModel));
    }
}
