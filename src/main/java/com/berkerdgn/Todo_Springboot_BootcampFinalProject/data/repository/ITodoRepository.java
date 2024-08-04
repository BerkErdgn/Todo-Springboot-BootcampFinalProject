package com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.entity.TodoEntity;
import java.util.Optional;

@Repository
public interface ITodoRepository extends CrudRepository<TodoEntity, Integer> {

    Optional<TodoEntity> findByTitle(String title);

    Optional<TodoEntity> findById(Integer id);

    Optional<TodoEntity> deleteAllByTodoIdIn(Iterable<Integer> ids);

}
