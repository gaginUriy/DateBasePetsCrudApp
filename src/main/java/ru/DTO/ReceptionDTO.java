package ru.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ReceptionDTO {
    @NotNull(message = " не может быть пустым")
    @Positive
    private int veterinaryReceptionId;

    @NotNull(message = " не может быть пустым")
    @Positive
    private int petsOwnerId;

    @NotNull(message = " не может быть пустым")
    @Positive
    private int petsId;

    private boolean vaccination;

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
