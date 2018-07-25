package com.spring.parking.model;

import java.util.List;

public class ParkingBoy {
    private int id;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(int id, List<ParkingLot> parkingLots) {
        this.id = id;
        this.parkingLots = parkingLots;
    }

    public ParkingBoy() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
