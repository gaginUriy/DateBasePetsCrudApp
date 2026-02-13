package ru.util.Excepion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoValidPeremetrExeption extends RuntimeException{


    private static final Logger log = LoggerFactory.getLogger(NoValidPeremetrExeption.class);

    public NoValidPeremetrExeption(String message) {
        super(message);
        log.warn("Exist error NotIdException ");
    }

}
