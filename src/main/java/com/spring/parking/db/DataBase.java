package com.spring.parking.db;

import com.spring.parking.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<ParkingLot> parkingLotList;
    private static List<ParkingBoy> boyList;
    private static List<Order> orderList;

    static {
        parkingLotList=new ArrayList<>();
        boyList=new ArrayList<>();
        orderList=new ArrayList<>();
        ParkingBoy jack=new ParkingBoy(1,"Jack");
        ParkingLot lot1=new ParkingLot(1,"东门停车场",3);
        ParkingLot lot2=new ParkingLot(2,"西门停车场",3);

        ParkingBoy tom=new ParkingBoy(2,"Tom");
        ParkingLot lot3=new ParkingLot(3,"北门停车场",3);
        ParkingLot lot4=new ParkingLot(4,"南门停车场",3);

        List<ParkingLot> jackParkingLot=new ArrayList<>();
        jackParkingLot.add(lot1);
        jackParkingLot.add(lot2);
        jack.setParkingLots(jackParkingLot);

        List<ParkingLot> tomParkingLot=new ArrayList<>();
        tomParkingLot.add(lot3);
        tom.setParkingLots(tomParkingLot);

        parkingLotList.addAll(jackParkingLot);
        parkingLotList.add(lot3);
        parkingLotList.add(lot4);
        boyList.add(jack);
        boyList.add(tom);

        orderList.add(new Order(new Car(12345),new Receipt("receipt: 23456")));
        orderList.add(new Order(new Car(33333),new Receipt("receipt: 00909")));

    }



    public static List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public static List<ParkingBoy> getBoyList() {
        return boyList;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void insertOrder(Order order) {
        orderList.add(order);
    }

    public static void insertParkingLot(ParkingLot newLot) {
        parkingLotList.add(newLot);
    }

    public static void insertParkingBoy(ParkingBoy newer) {
        boyList.add(newer);
    }
}
