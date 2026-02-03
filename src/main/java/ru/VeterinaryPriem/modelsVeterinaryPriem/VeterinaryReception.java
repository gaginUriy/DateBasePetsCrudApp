package ru.VeterinaryPriem.modelsVeterinaryPriem;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VeterinaryReception {
    private int veterinaryReceptionId;
    private int veterinaryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startOfReception;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endOfReception;
    private String reasonForRequest;

    public VeterinaryReception(){}

    public VeterinaryReception(int id, int veterinaryId, Date startOfReception, Date endOfReception, String reasonForTheRequest) {
        this.veterinaryReceptionId = id;
        this.veterinaryId = veterinaryId;
        this.startOfReception = startOfReception;
        this.endOfReception = endOfReception;
        this.reasonForRequest = reasonForTheRequest;
    }

    public int getVeterinaryReceptionId() {
        return veterinaryReceptionId;
    }

    public void setVeterinaryReceptionId(int veterinaryReceptionId) {
        this.veterinaryReceptionId = veterinaryReceptionId;
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
