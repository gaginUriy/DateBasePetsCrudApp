package ru.petsOwner.PetsOwnerExeption;

public class NoOwnerPetsExeption extends RuntimeException {
    public NoOwnerPetsExeption(String message) {
        super(message);
    }
}
