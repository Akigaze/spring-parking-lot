package com.spring.parking.model;

import com.spring.parking.model.exception.ParkingLotFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParkingLot {
    private int id;
    private String name;
    private int capacity;
    private Map<Receipt,Car> parkedCars=new HashMap<>();

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

    public String getFormatId() {
        return String.format("%03d",id);
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCarNum() {
        return parkedCars.size();
    }

    public Receipt park(Car car) {
        if (parkedCars.size()<capacity){
            Receipt card=new Receipt();
            parkedCars.put(card,car);
            return card;
        }else {
            throw new ParkingLotFullException();
        }
    }

    public Car unpark(Receipt card) {
        return parkedCars.remove(card);
    }

    public boolean isFull() {
        return parkedCars.size()==capacity;
    }

    public boolean containsReceipt(Receipt card){
        return parkedCars.containsKey(card);
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
        return getCarNum()>0;
    }
}
