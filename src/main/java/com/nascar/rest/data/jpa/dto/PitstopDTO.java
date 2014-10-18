package com.nascar.rest.data.jpa.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * A DTO object used to create pitstop
 *
 * @author sefverl.balasingam@outlook.com
 */
public class PitstopDTO {
    private Long id;
    @NotEmpty
    private long vehicleNumber;
    @NotEmpty
    private long inTime;
    @NotEmpty
    private long outTime;

    public PitstopDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public long getInTime() {
        return inTime;
    }

    public void setInTime(long inTime) {
        this.inTime = inTime;
    }

    public long getOutTime() {
        return outTime;
    }

    public void setOutTime(long outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
