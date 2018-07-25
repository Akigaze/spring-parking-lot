package com.spring.parking.db;

import com.spring.parking.model.ParkingBoy;
import com.spring.parking.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<ParkingLot> parkingLotList;
    private static List<ParkingBoy> boyList;

    static {
        parkingLotList=new ArrayList<>();
        boyList=new ArrayList<>();
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
    }



    public static List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public static List<ParkingBoy> getBoyList() {
        return boyList;
    }
}
