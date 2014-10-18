package com.nascar.rest.data.jpa.domain;

import javax.persistence.*;

@Entity
public class Pitstop {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int vehicleNumber;

    @Column(nullable = false)
    private double inTime;

    @Column(nullable = false)
    private double outTime;

    protected Pitstop() {
    }

    /**
     * Gets a builder used to create Pitstop objects
     *
     * @param vehicleNumber id of the vehicle
     * @param inTime        time at which pitstop was entered
     * @param outTime       time at which pitstop was exited
     * @return A new Builder instance
     */
    public static Builder getBuilder(int vehicleNumber, double inTime, double outTime) {
        return new Builder(vehicleNumber, inTime, outTime);
    }

    @Override
    public String toString() {
        return getVehicleNumber() + "," + getInTime() + "," + getOutTime();
    }

    public double getInTime() {
        return inTime;
    }

    public double getOutTime() {
        return outTime;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public static class Builder {
        Pitstop built;

        Builder(int vehicleNumber, double inTime, double outTime) {
            built = new Pitstop();
            built.vehicleNumber = vehicleNumber;
            built.inTime = inTime;
            built.outTime = outTime;
        }

        public Pitstop build() {
            return built;
        }
    }
}
