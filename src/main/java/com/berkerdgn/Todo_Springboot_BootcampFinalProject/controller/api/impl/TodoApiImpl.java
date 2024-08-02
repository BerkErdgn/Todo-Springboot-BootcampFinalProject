package com.berkerdgn.Todo_Springboot_BootcampFinalProject.controller.api.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.business.dto.TodoDto;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.business.services.ITodoServices;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.controller.api.ITodoApi;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.error.ApiResult;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.utils.frontend.React;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@CrossOrigin(origins = React.REACT_FRONTEND_PORT_URL)
@RequestMapping("/todo/api/v1")
public class TodoApiImpl implements ITodoApi<TodoDto> {

    // Injection
    private final ITodoServices iTodoServices;

    // SPEED DATA
    // http://localhost:4444/todo/api/v1/speed/5
    @Override
    @GetMapping(value = { "/speed/", "/speed/{id}" })
    public ResponseEntity<String> todoApiSpeedData(@PathVariable(name = "id", required = false) Integer data) {
        return ResponseEntity.ok(iTodoServices.todoSpeedData(data));
    }

    // DELETE ALL
    // http://localhost:4444/todo/api/v1/delete/all
    @Override
    @DeleteMapping(value = "/delete/all")
    public ResponseEntity<String> todoCategoryApiDeleteAllData() {
        return ResponseEntity.ok(iTodoServices.todoCategoryDeleteAllData());
    }

    // CRUD
    // CREATE
    // http://localhost:4444/todo/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> todoApiCreate(@Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(iTodoServices.todoServiceCreate(todoDto));
    }

    // LIST
    // http://localhost:4444/todo/api/v1/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<TodoDto>> todoApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iTodoServices.todoServiceList());
    }

    // FIND
    // http://localhost:4444/todo/api/v1/find/1
    @Override
    @GetMapping(value = { "/find/", "/find/{id}" })
    public ResponseEntity<?> todoApiFindById(@PathVariable(name = "id", required = false) Integer id) {
        ApiResult apiResult;
        // id==null
        if (id == null) {
            log.error("not found");
            apiResult = new ApiResult(404, "null pointer", "not found", "http://localhost:4444/todo/api/v1/find");
            return ResponseEntity.ok(apiResult);
        } else if (id == 0 || id < 0) {
            log.error("bad request");
            apiResult = new ApiResult(400, "bad request", "bad request", "http://localhost:4444/todo/api/v1/find");
            return ResponseEntity.ok(apiResult);
        }
        return ResponseEntity.status(HttpStatus.OK).body(iTodoServices.todoServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/todo/api/v1/update/1
    @Override
    @PutMapping(value = { "/update/", "/update/{id}" })
    public ResponseEntity<?> todoApiUpdateById(@PathVariable(name = "id", required = false) Integer id,
            @Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok().body(iTodoServices.todoServiceUpdateById(id, todoDto));
    }

    // DELETE
    // http://localhost:4444/todo/api/v1/delete
    @Override
    @DeleteMapping(value = { "/delete", "/delete/{id}" })
    public ResponseEntity<?> todoApiDeleteById(@PathVariable(name = "id", required = false) Integer id) {
        return ResponseEntity.ok().body(iTodoServices.todoServiceDeleteById(id));
    }
}
