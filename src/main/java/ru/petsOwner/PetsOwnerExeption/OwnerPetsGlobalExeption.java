package ru.petsOwner.PetsOwnerExeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OwnerPetsGlobalExeption {

    @ExceptionHandler
    public ResponseEntity<GetOwnerPetsExeption> handleException(NoOwnerPetsExeption exeption){
        GetOwnerPetsExeption data = new GetOwnerPetsExeption();
        data.setInfo(exeption.getMessage());
        return new ResponseEntity<>(data , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<GetOwnerPetsExeption> handleException(Exception exeption){
        GetOwnerPetsExeption data = new GetOwnerPetsExeption();
        data.setInfo(exeption.getMessage());
        return new ResponseEntity<>(data , HttpStatus.BAD_REQUEST);
    }}
