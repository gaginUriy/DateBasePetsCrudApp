package ru.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.models.OwnerPets;
import ru.models.Pets;
import ru.models.Veterinary;
import ru.models.VeterinaryReception;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ToNotificationPostDTO {
   private final Pets pets = new Pets();
    private final OwnerPets ownerPets = new OwnerPets();
    private final Veterinary veterinary =new Veterinary();
    private final VeterinaryReception veterinaryReception = new VeterinaryReception();


    @NotNull(message = " не может быть пустым")
    private String  petsOwnerName  ;

    @NotNull(message = " не может быть пустым")
    private String  petsName;

    @NotNull(message = " не может быть пустым")
    private String  veterinaryName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = " не может быть пустым")
    private Date startOfReception;

    @NotEmpty(message = " не может быть пустым")
    private String telegram;


    private String email;


    public ToNotificationPostDTO(String petsOwnerName, String petsName, String veterinaryName, Date startOfReception, String telegram, String email) {
        this.petsOwnerName = petsOwnerName;
        this.petsName = petsName;
        this.veterinaryName = veterinaryName;
        this.startOfReception = startOfReception;
        this.telegram = telegram;
        this.email = email;
    }

    public String getPetsOwnerName() {
        return petsOwnerName;
    }

    public void setPetsOwnerName(String  petsOwnerName) {
        this.petsOwnerName = petsOwnerName;
    }

    public String  getPetsName() {
        return petsName;
    }

    public void setPetsName(String  petsName) {
        this.petsName = petsName;
    }

    public String  getVeterinaryName() {
        return veterinaryName;
    }

    public void setVeterinaryName(String  veterinaryName) {
        this.veterinaryName = veterinaryName;
    }

    public Date getStartOfReception() {
        return startOfReception;
    }

    public void setStartOfReception(Date startOfReception) {
        this.startOfReception = startOfReception;
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
