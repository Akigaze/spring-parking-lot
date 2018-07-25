package com.spring.parking.service;

import com.spring.parking.model.ParkingBoy;
import com.spring.parking.model.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotService {


    private List<ParkingLot> parkingLotList=new ArrayList<>();
    private List<ParkingBoy> boyList=new ArrayList<>();

    public ParkingLotService() {
    }

    public ParkingLotService(List<ParkingLot> parkingLotList, List<ParkingBoy> boyList) {
        this.parkingLotList = parkingLotList;
        this.boyList = boyList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingBoy> getBoyList() {
        return boyList;
    }

    public void setBoyList(List<ParkingBoy> boyList) {
        this.boyList = boyList;
    }


    public ParkingLot buildParkingLot(ParkingLot newLot) {
        parkingLotList.add(newLot);
        return newLot;
    }
}
