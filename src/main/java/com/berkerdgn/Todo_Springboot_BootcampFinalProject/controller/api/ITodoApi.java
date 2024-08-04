package com.berkerdgn.Todo_Springboot_BootcampFinalProject.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITodoApi<D> {

    // SPEED DATA
    public ResponseEntity<String> todoApiSpeedData(Integer data);

    // DELETE ALL
    public ResponseEntity<String> todoCategoryApiDeleteAllData();

    // DELETE ALL COMPLETED DATA
    public ResponseEntity<String> todoApiDeleteCompletedData();

    // CRUDE
    // CREATE
    public ResponseEntity<?> todoApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>> todoApiList();

    // FIND
    public ResponseEntity<?> todoApiFindById(Integer id);

    // UPDATE
    public ResponseEntity<?> todoApiUpdateById(Integer id, D d);

    // DELETE
    public ResponseEntity<?> todoApiDeleteById(Integer id);

}
