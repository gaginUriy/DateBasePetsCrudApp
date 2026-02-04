package ru.pets.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.datetime.joda.LocalDateParser;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Pets {
    @Null
    private int id;
    @NotBlank(message = "No type")
    private  PetsType type;
    @NotBlank
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate vaccination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endVaccination ;
    private PetsColor color;



    public Pets(int id, LocalDate endVaccination, LocalDate vaccination) {
        this.id = id;
        this.endVaccination = endVaccination;
        this.vaccination = vaccination;
    }

    public Pets(int id, PetsType type, String name,LocalDate endVaccination, LocalDate vaccination, PetsColor color) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.vaccination = vaccination;
        this.endVaccination = endVaccination;
        this.color = color;
    }

    public LocalDate getVaccination() {
        return vaccination;
    }

    public void setVaccination(LocalDate vaccination) {
        this.vaccination = vaccination;
    }

    public LocalDate getEndVaccination() {
        return endVaccination;
    }

    public void setEndVaccination(LocalDate endVaccination) {
        this.endVaccination = endVaccination;
    }

    public Pets(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PetsType getType() {
        return type;
    }

    public void setType(PetsType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public PetsColor getColor() {
        return color;
    }

    public void setColor(PetsColor color) {
        this.color = color;
    }


}
