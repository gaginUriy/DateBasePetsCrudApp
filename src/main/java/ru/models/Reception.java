package ru.models;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "reception")

public class Reception {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "veterinary_reception_id")
    @NotEmpty(message = " не может быть пустым")
    @Positive
    private int veterinaryReceptionId;

    @Column(name = "pets_owner_id")
    @NotEmpty(message = " не может быть пустым")
    @Positive
    private int petsOwnerId;

    @Column(name = "pets_id")
    @NotEmpty(message = " не может быть пустым")
    @Positive
    private int petsId;

    @Column(name = "vaccination")
    private boolean vaccination;



    public Reception(){}

    public Reception(int id, int veterinaryReceptionId, int petsOwnerId, int petsId, boolean vaccination) {
        this.id = id;
        this.veterinaryReceptionId = veterinaryReceptionId;
        this.petsOwnerId = petsOwnerId;
        this.petsId = petsId;
        this.vaccination = vaccination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVeterinaryReceptionId() {
        return veterinaryReceptionId;
    }

    public void setVeterinaryReceptionId(int veterinaryReceptionId) {
        this.veterinaryReceptionId = veterinaryReceptionId;
    }

    public int getPetsOwnerId() {
        return petsOwnerId;
    }

    public void setPetsOwnerId(int petsOwnerId) {
        this.petsOwnerId = petsOwnerId;
    }

    public int getPetsId() {
        return petsId;
    }

    public void setPetsId(int petsId) {
        this.petsId = petsId;
    }

    public boolean isVaccination() {
        return vaccination;
    }

    public void setVaccination(boolean vaccination) {
        this.vaccination = vaccination;
    }
}
