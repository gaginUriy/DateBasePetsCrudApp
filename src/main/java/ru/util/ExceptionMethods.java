package ru.util;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.models.Pets;

import java.util.List;

@Service
public class ExceptionMethods {


    public ResponseEntity<?> validationModelField(BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errorsMessage = bindingResult.getFieldErrors();

            for (FieldError e : errorsMessage) {
                stringBuilder
                        .append(e.getField())
                        .append("-")
                        .append(e.getDefaultMessage())
                        .append(";");
            }
            throw new NoValidPeremetrExeption(stringBuilder.toString());

        }
        return null;
    }

     public <X>ResponseEntity<?> validationId( X vallue, int id){
        if ( vallue == null )
        {
            throw new NotIdException("No id "+ id);
        }
         return null;
    }
}