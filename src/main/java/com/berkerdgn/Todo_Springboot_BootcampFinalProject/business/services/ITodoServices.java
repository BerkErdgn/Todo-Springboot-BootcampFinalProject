package com.berkerdgn.Todo_Springboot_BootcampFinalProject.business.services;

import java.util.List;

public interface ITodoServices<D, E> {

    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // SPEED DATA
    public String todoSpeedData(Integer data);

    // DELETE ALL
    public String todoCategoryDeleteAllData();

    // CRUDE
    // CREATE
    public D todoServiceCreate(D d);

    // LIST
    public List<D> todoServiceList();

    // FIND
    public D todoServiceFindById(Integer id);

    // UPDATE
    public D todoServiceUpdateById(Integer id, D d);

    // DELETE
    public D todoServiceDeleteById(Integer id);

    // DELETE Completed Todo
    public String todoServiceDeleteCompletedData();

}
