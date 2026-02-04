package ru.VeterinaryPriem.modelsVeterinaryPriem;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.validation.constraints.*;
import java.util.Date;

public class VeterinaryReception {
    @Null
    private int id;
    @NotNull
    private int veterinaryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotEmpty
    private Date startOfReception;
    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endOfReception;
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
