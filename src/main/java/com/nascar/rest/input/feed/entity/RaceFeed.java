package com.nascar.rest.input.feed.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RaceFeed {

    @JsonProperty("lap_number")
    private int lapNumber;

    @JsonProperty("race_id")
    private int raceId;

    @JsonProperty("vehicles")
    private List<RaceVehicle> vehicleList;

    public List<RaceVehicle> getVehicleList() {
        return vehicleList;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public int getRaceId() {
        return raceId;
    }

    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, true);
    }
}
