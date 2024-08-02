package com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
@Entity(name = "Todos")
@Table(name = "todos")
public class TodoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id", unique = true, nullable = false, updatable = false, insertable = true)
    private int todoId;

    @Column(name = "todo_title")
    private String title;

    @Column(name = "todo_completed")
    private boolean completed;

}
