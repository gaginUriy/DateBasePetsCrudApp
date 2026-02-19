package ru.DTO;

import java.time.LocalDateTime;
import java.util.Date;

public class IntegrationReceptionDTO {
    private String ownerFirstName;
    private String petName;
    private String veterinaryFirstName;
    private Date receptionStart;
    private String email;
    private String telegram;

    public IntegrationReceptionDTO(String ownerFirstName, String petName, String veterinaryFirstName, Date receptionStart, String email, String telegram) {
        this.ownerFirstName = ownerFirstName;
        this.petName = petName;
        this.veterinaryFirstName = veterinaryFirstName;
        this.receptionStart = receptionStart;
        this.email = email;
        this.telegram = telegram;
    }

    public IntegrationReceptionDTO(){}
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getVeterinaryFirstName() {
        return veterinaryFirstName;
    }

    public void setVeterinaryFirstName(String veterinaryFirstName) {
        this.veterinaryFirstName = veterinaryFirstName;
    }

    public Date getReceptionStart() {
        return receptionStart;
    }

    public void setReceptionStart(Date receptionStart) {
        this.receptionStart = receptionStart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }
}
