package com.spring.parking.service;

import com.spring.parking.db.DataBase;
import com.spring.parking.model.ParkingBoy;
import com.spring.parking.model.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotService {


    private List<ParkingLot> parkingLotList=new ArrayList<>();
    private List<ParkingBoy> boyList=new ArrayList<>();

    {
        parkingLotList=DataBase.getParkingLotList();
        boyList=DataBase.getBoyList();
    }

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

    public ParkingBoy hireParkingBoy(ParkingBoy newer) {
        boyList.add(newer);
        return newer;
    }


    public void assignParkingLotToParkingBoy(int boyID, int lotID) {
        ParkingLot lot=parkingLotList.stream().filter(l->l.getId()==lotID).findFirst().get();
        ParkingBoy boy=boyList.stream().filter(b->b.getId()==boyID).findFirst().get();
        if (!boy.getParkingLots().contains(lot)){
            boy.getParkingLots().add(lot);
        }
    }
}
