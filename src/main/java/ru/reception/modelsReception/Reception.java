package ru.reception.modelsReception;

public class Reception {
    private int receptionId;
    private int veterinaryReceptionId;
    private int petsOwnerId;
    private int pitsId;
    private boolean vaccination;

    public Reception(){}

    public Reception(int receptionId, int veterinaryReceptionId, int petsOwnerId, int pitsId, boolean vaccination) {
        this.receptionId = receptionId;
        this.veterinaryReceptionId = veterinaryReceptionId;
        this.petsOwnerId = petsOwnerId;
        this.pitsId = pitsId;
        this.vaccination = vaccination;
    }

    public int getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(int receptionId) {
        this.receptionId = receptionId;
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

    public int getPitsId() {
        return pitsId;
    }

    public void setPitsId(int pitsId) {
        this.pitsId = pitsId;
    }

    public boolean isVaccination() {
        return vaccination;
    }

    public void setVaccination(boolean vaccination) {
        this.vaccination = vaccination;
    }
}
