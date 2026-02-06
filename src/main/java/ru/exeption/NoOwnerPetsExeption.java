package ru.exeption;

public class NoOwnerPetsExeption extends RuntimeException {
    public NoOwnerPetsExeption(String message) {
        super(message);
    }
}
