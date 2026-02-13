package ru.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class OwnerPetsDTO {
    @NotEmpty(message = " не может быть пустым")
    private String firstName;

    @NotEmpty(message = " не может быть пустым")
    private String lastName;

    @NotNull(message = " не может быть пустым")
    @NotBlank
    private String phone;

    @NotNull(message = " не может быть пустым")
    @Positive
    private int petsId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    @NotEmpty(message = " не может быть пустым")
    private String telegram;

    @Email(message = " значение не корректно")
    private String email;


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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
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
