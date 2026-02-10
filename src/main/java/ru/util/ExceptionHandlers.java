package ru.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

   @ExceptionHandler
    public ResponseEntity<ClassForExcepted> handlerExeption(NotIdException e)
    {
        ClassForExcepted response = new ClassForExcepted(e.getMessage());
        response.setMessage(e.getMessage());
        System.out.println("NotIdException exist");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//

    @ExceptionHandler()
    public ResponseEntity<ClassForExcepted> handlerExeption(NoValidPeremetrExeption e) {
        System.out.println("NoValidPeremetrExeption exist");
        ClassForExcepted response = new ClassForExcepted(e.getMessage().toString());

        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }


 @ExceptionHandler
    public ResponseEntity<ClassForExcepted> handlerExeption(Exception e)
    {
        ClassForExcepted response = new ClassForExcepted(e.getMessage());
        response.setMessage(e.getMessage());
        System.out.println("Exception exist");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
