package ru.pets.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.datetime.joda.LocalDateParser;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Pets {
    private int id;
    private  PetsType type;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date vaccination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endVaccination = vaccination;
    private PetsColor color;



    public Pets(int id, Date endVaccination, Date vaccination) {
        this.id = id;
        this.endVaccination = endVaccination;
        this.vaccination = vaccination;
    }

    public Pets(int id, PetsType type, String name,Date endVaccination, Date vaccination, PetsColor color) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.vaccination = vaccination;
        this.endVaccination = endVaccination;
        this.color = color;
    }

    public Date getVaccination() {
        return vaccination;
    }

    public void setVaccination(Date vaccination) {
        this.vaccination = vaccination;
    }

    public Date getEndVaccination() {
        return endVaccination;
    }

    public void setEndVaccination(Date endVaccination) {
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
