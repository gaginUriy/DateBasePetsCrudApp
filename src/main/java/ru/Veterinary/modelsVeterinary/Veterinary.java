package ru.Veterinary.modelsVeterinary;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Veterinary {
    private int veterinaryId;
    private String lastName;
    private String firstName;
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    public Veterinary() {
    }

    public Veterinary(int Id, String lastName, String firstName, String phone, Date birthday) {
        this.veterinaryId = Id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.birthday = birthday;
    }



    public int getVeterinaryId() {
        return veterinaryId;
    }

    public void setVeterinaryId(int veterinaryId) {
        this.veterinaryId = veterinaryId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
