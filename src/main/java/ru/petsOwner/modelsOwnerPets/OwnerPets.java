package ru.petsOwner.modelsOwnerPets;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OwnerPets {
    private int petsOwnerId;
    private String firstName;
    private String lastName;
    private String phone;
    private int petsId;
    private Date birthDay;
    private String telegram;
    private String email;

    public OwnerPets() {}

    public OwnerPets(int id, String firstName, String lastName, String phone, int petsId, Date birthDay, String telegram, String email) {
        this.petsOwnerId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.petsId = petsId;
        this.birthDay = birthDay;
        this.telegram = telegram;
        this.email = email;
    }

    public int getPetsOwnerId() {
        return petsOwnerId;
    }

    public void setPetsOwnerId(int petsOwnerId) {
        this.petsOwnerId = petsOwnerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPetsId() {
        return petsId;
    }

    public void setPetsId(int petsId) {
        this.petsId = petsId;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthday) {
        this.birthDay = birthday;
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
