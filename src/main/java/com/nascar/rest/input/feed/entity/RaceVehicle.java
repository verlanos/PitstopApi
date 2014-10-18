package com.nascar.rest.input.feed.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RaceVehicle {
    @JsonProperty("vehicle_number")
    private int vehicleNumber;
    @JsonProperty("pit_stops")
    private List<RacePitstop> pitstops;

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public List<RacePitstop> getPitstops() {
        return pitstops;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, true);
    }
}
