package com.spring.parking.model;

import com.spring.parking.model.exception.ParkingLotFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParkingLot {
    private int id;
    private String name;
    private int capacity;
    private Map<Receipt,Car> cars =new HashMap<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Receipt, Car> getCars() {
        return cars;
    }

    public void setCars(Map<Receipt, Car> cars) {
        this.cars = cars;
    }

    public ParkingLot(){}

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(String name, int capacity) {
        this((int)(Math.random()*100),name,capacity);
    }

    public ParkingLot(int id, String name, int capacity) {
        this.id=id;
        this.name=name;
        this.capacity=capacity;
    }

    public int getId() {
        return id;
    }

    public String formatId() {
        return String.format("%03d",id);
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int countCarNumber() {
        return cars.size();
    }

    public Receipt park(Car car,Receipt receipt) {
        if (cars.size()<capacity){
            cars.put(receipt,car);
            return receipt;
        }else {
            throw new ParkingLotFullException();
        }
    }

    public Car unpark(Receipt card) {
        return cars.remove(card);
    }

    public boolean full() {
        return cars.size()==capacity;
    }

    public boolean containsReceipt(Receipt card){
        return cars.containsKey(card);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot lot = (ParkingLot) o;
        return id == lot.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public boolean hasCar() {
        return countCarNumber()>0;
    }
}
