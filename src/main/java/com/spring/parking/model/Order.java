package com.spring.parking.model;

import com.spring.parking.model.Car;
import com.spring.parking.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Order {

    private int id;
    @Autowired
    private Car parkedCar;
    @Autowired
    private Receipt receipt;
    private boolean deal=false;

    public Order() {
    }

    public Order( Car parkedCar, Receipt receipt) {
        this.parkedCar = parkedCar;
        this.receipt = receipt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void setParkedCar(Car parkedCar) {
        this.parkedCar = parkedCar;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public boolean isDeal() {
        return deal;
    }

    public void setDeal(boolean deal) {
        this.deal = deal;
    }
}
