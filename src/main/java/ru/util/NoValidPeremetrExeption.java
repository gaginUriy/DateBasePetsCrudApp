package ru.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NoValidPeremetrExeption extends RuntimeException{


    public NoValidPeremetrExeption(String message) {
        super(message);
        System.out.println("NotIdException exist1");
    }

}
