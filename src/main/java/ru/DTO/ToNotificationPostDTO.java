package ru.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

public class ToNotificationPostDTO {


    @NotNull(message = " не может быть пустым")
    @Positive
    private int petsOwnerName;

    @NotNull(message = " не может быть пустым")
    @Positive
    private int petsName;

    @NotNull(message = " не может быть пустым")
    private int veterinaryName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = " не может быть пустым")
    private Date startOfReception;


    @NotNull(message = " не может быть пустым")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endOfReception;

    @NotEmpty(message = " не может быть пустым")
    private String telegram;


    private String email;

    public int getPetsOwnerName() {
        return petsOwnerName;
    }

    public void setPetsOwnerName(int petsOwnerName) {
        this.petsOwnerName = petsOwnerName;
    }

    public int getPetsName() {
        return petsName;
    }

    public void setPetsName(int petsName) {
        this.petsName = petsName;
    }

    public int getVeterinaryName() {
        return veterinaryName;
    }

    public void setVeterinaryName(int veterinaryName) {
        this.veterinaryName = veterinaryName;
    }

    public Date getStartOfReception() {
        return startOfReception;
    }

    public void setStartOfReception(Date startOfReception) {
        this.startOfReception = startOfReception;
    }

    public Date getEndOfReception() {
        return endOfReception;
    }

    public void setEndOfReception(Date endOfReception) {
        this.endOfReception = endOfReception;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
