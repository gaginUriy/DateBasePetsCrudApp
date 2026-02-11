package ru.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "veterinary")
public class Veterinary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "last_name")
    @NotEmpty(message = " не может быть пустым")
    private String lastName;

    @Column(name = "first_name")
    @NotEmpty(message = " не может быть пустым")
    private String firstName;

    @Column(name = "phone")
    @NotEmpty(message = " не может быть пустым")
    private String phone;

    @Column(name = "birthday")
    @NotNull(message = " не может быть пустым")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public Veterinary() {
    }

    public Veterinary( String lastName, String firstName, String phone, LocalDate birthday) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.birthday = birthday;
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
