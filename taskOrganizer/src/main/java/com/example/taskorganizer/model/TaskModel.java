package com.example.taskorganizer.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskModel {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String name_task;
    @Column(nullable = false, unique = true, length = 7)
    private String discription_task;
    @Column(nullable = false, length = 70)
    private LocalDateTime start_task;
    @Column(nullable = false, length = 70)
    private LocalDateTime prevision_task;
    @Column(nullable = false, length = 70)
    private LocalDateTime completion_task;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
