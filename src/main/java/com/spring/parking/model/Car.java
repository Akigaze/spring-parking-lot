package com.spring.parking.model;

public class Car {
    private int id;
    public Car(){

    }
    public Car(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car){
            final Car car=(Car)obj;
            if (this.id==car.id){
                return true;
            }
        }
        return false;
    }
}
