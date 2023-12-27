package com.example.task_meneger.task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "tasks")
@Entity(name = "tasks")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name_task;

    private String description_task;
    private Date start_task;
    private Date prevision_task;
    private Date completion_task;

    public Task(TaskRequestDTO data){
        this.name_task = data.name_task();
        this.description_task = data.description_task();
        this.start_task = data.start_task();
        this.prevision_task = data.prevision_task();
        this.completion_task = data.completion_task();

    }
}
