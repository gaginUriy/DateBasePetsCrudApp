package ru.util.Excepion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler
    public ResponseEntity<ClassForExcepted> handlerExeption(NotIdException e)
    {
        ClassForExcepted response = new ClassForExcepted(e.getMessage());
        response.setMessage(e.getMessage());
        log.warn("NotIdException exist");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//

    @ExceptionHandler()
    public ResponseEntity<ClassForExcepted> handlerExeption(NoValidPeremetrExeption e) {
        log.warn("NoValidPeremetrExeption exist");
        ClassForExcepted response = new ClassForExcepted(e.getMessage().toString());

        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }


// @ExceptionHandler
//    public ResponseEntity<ClassForExcepted> handlerExeption(Exception e)
//    {
//        ClassForExcepted response = new ClassForExcepted(e.getMessage());
//        response.setMessage("Нейизвестная ошибка");
//        log.warn("Exception exist");
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
}
