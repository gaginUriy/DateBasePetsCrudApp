package ru.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;


@Entity
@Table(name = "pets")
public class Pets {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private  PetsType type;

    @Column(name = "name")
    private String name;

    @Column(name = "vaccination")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate vaccination;

    @Column(name = "vaccination_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endVaccination ;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private PetsColor color;



    public Pets(){}

    public Pets(PetsType type, String name,LocalDate endVaccination, LocalDate vaccination, PetsColor color) {
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
