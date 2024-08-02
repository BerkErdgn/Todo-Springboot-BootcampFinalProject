package com.berkerdgn.Todo_Springboot_BootcampFinalProject.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.annotation.AUniqueTodo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class TodoDto implements Serializable {

    private int id;

    @AUniqueTodo
    @NotEmpty(message = "Lütfen doldurun")
    @Size(min = 2, message = "Lütfen faha uzun bir cümle girin")
    private String title;

    private boolean completed;

}