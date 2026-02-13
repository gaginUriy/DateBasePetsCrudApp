package ru.util.Excepion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.repositories.PetRepository;

import java.util.List;

@Service
public class ExceptionMethods {

    public final PetRepository petRepository;
@Autowired
    public ExceptionMethods(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
//TODO хожу 2 раза в БД для проверка существования ID

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

    public <X>ResponseEntity<?> validationThrowIdExqist(int id){
        if ( id ==0)
        {
            throw new NotIdException("No id "+ id);
        }
        return null;
    }

    public void existByID(int id ){
     if(petRepository.existsById(id)){
        return ;
     }
        throw new NotIdException("No id "+ id);
    }
}

