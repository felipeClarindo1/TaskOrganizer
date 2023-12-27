package com.example.task_meneger.task;

import java.util.Date;

public record TaskRequestDTO(String name_task,String description_task,Date start_task,Date prevision_task, Date completion_task) {
}
