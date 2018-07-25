package com.spring.parking.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingBoy {
    private int id;
    private String name;
    @Autowired
    private List<ParkingLot> parkingLots;

    public ParkingBoy(int id,String name) {
        this.id = id;
        this.name=name;
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
