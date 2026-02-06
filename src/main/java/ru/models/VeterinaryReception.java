package ru.models;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity
@Table(name = "veterinary_reception")

public class VeterinaryReception {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "veterinary_id")
    @NotNull
    private int veterinaryId;

    @Column(name = "start_of_reception")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotEmpty
    private Date startOfReception;

    @Column(name = "end_of_reception")
    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endOfReception;

    @Column(name = "reason_for_request")
    private String reasonForRequest;

    public VeterinaryReception(){}

    public VeterinaryReception(int id, int veterinaryId, Date startOfReception, Date endOfReception, String reasonForTheRequest) {
        this.id = id;
        this.veterinaryId = veterinaryId;
        this.startOfReception = startOfReception;
        this.endOfReception = endOfReception;
        this.reasonForRequest = reasonForTheRequest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVeterinaryId() {
        return veterinaryId;
    }

    public void setVeterinaryId(int veterinaryId) {
        this.veterinaryId = veterinaryId;
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

    public String getReasonForRequest() {
        return reasonForRequest;
    }

    public void setReasonForRequest(String reasonForRequest) {
        this.reasonForRequest = reasonForRequest;
    }
}
