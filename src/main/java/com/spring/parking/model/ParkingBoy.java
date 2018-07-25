package com.spring.parking.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingBoy {
    private int id;
    @Autowired
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
