package com.example.taskorganizer.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.time.LocalDateTime;
import java.util.Date;




public class TaskDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String name_task;

    @NotBlank
    private String discription_task;

    @NotBlank
    private LocalDateTime start_task;

    @NotBlank
    private LocalDateTime prevision_task;

    @NotBlank
    private LocalDateTime completion_task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }

    public String getDiscription_task() {
        return discription_task;
    }

    public void setDiscription_task(String discription_task) {
        this.discription_task = discription_task;
    }

    public LocalDateTime getStart_task() {
        return start_task;
    }

    public void setStart_task(LocalDateTime start_task) {
        this.start_task = start_task;
    }

    public LocalDateTime getPrevision_task() {
        return prevision_task;
    }

    public void setPrevision_task(LocalDateTime prevision_task) {
        this.prevision_task = prevision_task;
    }

    public LocalDateTime getCompletion_task() {
        return completion_task;
    }

    public void setCompletion_task(LocalDateTime completion_task) {
        this.completion_task = completion_task;
    }
}
