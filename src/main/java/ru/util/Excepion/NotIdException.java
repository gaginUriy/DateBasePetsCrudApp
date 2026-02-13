package ru.util.Excepion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotIdException extends RuntimeException{


    private static final Logger log = LoggerFactory.getLogger(NotIdException.class);


    public NotIdException(String message){super(message);
        log.warn("Exist error NotIdException ");

    }

}
