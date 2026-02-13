package ru.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class VeterinaryReceptionDTO {

    @NotNull(message = " не может быть пустым")

    private int veterinaryId;

    @NotNull(message = " не может быть пустым")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    @NotNull(message = " не может быть пустым")
    private Date startOfReception;


    @NotNull(message = " не может быть пустым")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endOfReception;


    private String reasonForRequest;


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
