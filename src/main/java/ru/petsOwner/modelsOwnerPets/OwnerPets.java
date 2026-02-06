package ru.petsOwner.modelsOwnerPets;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Table(name = "pets_owner")
public class OwnerPets {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="first_name" )
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "phone")
    private String phone;

    @Column(name = "pets_id")
  @Positive
    private int petsId;

    @Column(name = "birthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    @Column(name = "telegram")
    private String telegram;

    @Column(name = "email")
    @Email(message = "Некорректный email")
    private String email;

    public OwnerPets() {}

    public OwnerPets( String firstName, String lastName, String phone, int petsId, LocalDate birthDay, String telegram, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.petsId = petsId;
        this.birthDay = birthDay;
        this.telegram = telegram;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthday) {
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
