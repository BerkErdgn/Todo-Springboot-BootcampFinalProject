package com.berkerdgn.Todo_Springboot_BootcampFinalProject.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.repository.ITodoRepository;

@RequiredArgsConstructor
public class UniqueTodoValidation implements ConstraintValidator<AUniqueTodo, String> {

    private final ITodoRepository iTodoRepository;

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        if (title == null) {
            return true;
        }

        boolean isSameTitle = iTodoRepository.findByTitle(title).isPresent();
        if (isSameTitle) {
            System.out.println(title + " Aynı isimde Database bulunmaktadır. Farklı bir database giriniz");
            return false;
        } else {
            System.out.println(title + " Harika bu title ismini yazabilirsiniz");
            return true;
        }
    }
}
