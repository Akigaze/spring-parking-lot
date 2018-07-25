package com.spring.parking.model;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingLot {
    private int id;
    private String name;
    private int capacity;
    private List<Car> cars;

    public ParkingLot() {
    }

    public ParkingLot(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
