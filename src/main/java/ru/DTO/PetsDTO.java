package ru.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.models.PetsColor;
import ru.models.PetsType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PetsDTO {


    @Enumerated(EnumType.STRING)
    private PetsType type;

    @NotEmpty(message = " не может быть пустым")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate vaccination;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endVaccination ;

    @NotNull(message = " не может быть пустым")
    private PetsColor color;

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

    public PetsColor getColor() {
        return color;
    }

    public void setColor(PetsColor color) {
        this.color = color;
    }
}
