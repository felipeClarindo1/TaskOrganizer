package com.example.task_meneger.task;

import java.util.Date;

public record TaskResponseDTO(Long id, String name_task, String description_task, Date start_task, Date prevision_task, Date completion_task) {
    public TaskResponseDTO(Task task){
        this(task.getId(), task.getName_task(), task.getDescription_task(), task.getStart_task(),task.getPrevision_task(),task.getCompletion_task());
    }
}
