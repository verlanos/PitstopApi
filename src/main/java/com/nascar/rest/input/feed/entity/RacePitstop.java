package com.nascar.rest.input.feed.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RacePitstop {
    @JsonProperty("pit_in_elapsed_time")
    private double inElapsedTime;
    @JsonProperty("pit_out_elapsed_time")
    private double outElapsedTime;

    public double getInElapsedTime() {
        return inElapsedTime;
    }

    public double getOutElapsedTime() {
        return outElapsedTime;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, false);
    }
}
