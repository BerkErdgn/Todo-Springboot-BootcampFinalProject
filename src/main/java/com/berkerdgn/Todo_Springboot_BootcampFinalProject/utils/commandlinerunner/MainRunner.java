package com.berkerdgn.Todo_Springboot_BootcampFinalProject.utils.commandlinerunner;

import com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.entity.TodoEntity;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.repository.ITodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Lombok
@RequiredArgsConstructor
@Configuration
@Log4j2
public class MainRunner {

    // injection
    private final ITodoRepository iTodoRepository;

    // START
    public void start() {
        log.info("######Start##########");
    }

    // Commend Line Runner
    @Bean
    public CommandLineRunner todo() {
        return args -> {
            log.info("Todos");
            System.out.println("Todo");
            TodoEntity todoEntity1 = TodoEntity.builder().title("deneme1").build();
            iTodoRepository.save(todoEntity1);
            TodoEntity todoEntity2 = TodoEntity.builder().title("deneme2").build();
            iTodoRepository.save(todoEntity2);
            TodoEntity todoEntity3 = TodoEntity.builder().title("deneme3").build();
            iTodoRepository.save(todoEntity3);
        };
    }

    // END
    public void end() {
        log.info("######End##########");
    }

}
