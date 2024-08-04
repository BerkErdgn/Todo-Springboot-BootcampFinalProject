package com.berkerdgn.Todo_Springboot_BootcampFinalProject.business.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import com.berkerdgn.Todo_Springboot_BootcampFinalProject.bean.ModelMapperBean;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.business.dto.TodoDto;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.business.services.ITodoServices;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.entity.TodoEntity;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.repository.ITodoRepository;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.exception.BerkErdgnException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class TodoServicesImpl implements ITodoServices<TodoDto, TodoEntity> {

    // INJECTION
    private final ITodoRepository iTodoRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    @Override
    public TodoDto entityToDto(TodoEntity todoEntity) {
        return modelMapperBean.getModelMapperMethod().map(todoEntity, TodoDto.class);
    }

    @Override
    public TodoEntity dtoToEntity(TodoDto todoDto) {
        return modelMapperBean.getModelMapperMethod().map(todoDto, TodoEntity.class);
    }

    // SPEED DATA
    @Override
    public String todoSpeedData(Integer data) {
        if (data != null) {
            for (int i = 0; i <= data; i++) {
                TodoEntity todoEntity = new TodoEntity();
                todoEntity.setTitle("Todo : " + UUID.randomUUID().toString());
                iTodoRepository.save(todoEntity);
            }
        } else {
            throw new BerkErdgnException("Speed Data Oluşturulamadı.");
        }
        return "";
    }

    // DELETE ALL
    @Override
    public String todoCategoryDeleteAllData() {
        iTodoRepository.deleteAll();
        return todoServiceList() + "tane veri silindi.";
    }

    // CRUDE
    // CREATE
    @Override
    @Transactional
    public TodoDto todoServiceCreate(TodoDto todoDto) {
        if (todoDto != null) {
            TodoEntity todoEntity = dtoToEntity(todoDto);
            iTodoRepository.save(todoEntity);
            todoDto.setId(todoEntity.getTodoId());
            todoDto.setTitle(todoEntity.getTitle());
            return todoDto;
        } else {
            throw new NullPointerException(TodoDto.class + " boş");
        }

    }

    // LiSt
    @Override
    public List<TodoDto> todoServiceList() {
        Iterable<TodoEntity> todoEntityIterator = iTodoRepository.findAll();
        List<TodoDto> todoDtoList = new ArrayList<>();
        for (TodoEntity entity : todoEntityIterator) {
            TodoDto todoDto = entityToDto(entity);
            todoDtoList.add(todoDto);
        }
        log.info("todo title list: " + todoDtoList.size());
        return todoDtoList;
    }

    // Find
    @Override
    public TodoDto todoServiceFindById(Integer id) {
        TodoEntity findtodoEntity = null;
        if (id != null) {
            findtodoEntity = iTodoRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(id + " nolu veri yok"));
        } else if (id == null) {
            throw new NullPointerException(" todo id null");
        }
        return entityToDto(findtodoEntity);
    }

    // Update
    @Override
    @Transactional
    public TodoDto todoServiceUpdateById(Integer id, TodoDto todoDto) {
        TodoDto findtodoDto = todoServiceFindById(id);
        if (findtodoDto != null) {
            TodoEntity todoEntity = dtoToEntity(todoDto);
            todoEntity.setTitle(todoDto.getTitle());
            iTodoRepository.save(todoEntity);
            return findtodoDto;
        }
        return null;
    }

    // Delete
    @Override
    @Transactional
    public TodoDto todoServiceDeleteById(Integer id) {
        TodoDto findtodoDto = todoServiceFindById(id);
        if (findtodoDto != null) {
            iTodoRepository.deleteById(id);
            return findtodoDto;
        }
        return null;
    }

    // DELETE COMPLETED
    @Override
    @Transactional
    public String todoServiceDeleteCompletedData() {
        List<TodoDto> allTodos = todoServiceList();
        List<Integer> idsToDelete = new ArrayList<>();

        for (TodoDto todoDto : allTodos) {
            if (todoDto.isCompleted()) {
                idsToDelete.add(todoDto.getId());
            }
        }

        if (!idsToDelete.isEmpty()) {
            iTodoRepository.deleteAllById(idsToDelete);
            return idsToDelete.size() + " tamamlanmış todo silindi.";
        }

        return "Silinecek tamamlanmış todo bulunamadı.";
    }
}
