package ru.reception.modelsReception;

import javax.validation.constraints.*;

public class Reception {
    private int id;
    @NotNull
    @Positive
    private int veterinaryReceptionId;
    @NotNull
    @Positive
    private int petsOwnerId;
    @NotNull
    @Positive
    private int petsId;
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
