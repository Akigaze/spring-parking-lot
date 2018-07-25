package com.spring.parking.service;

import com.spring.parking.db.DataBase;
import com.spring.parking.model.*;
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

    public ParkingBoy getParkingBoyById(int id) {
        ParkingBoy boy=null;
        for (ParkingBoy b:boyList){
            if (b.getId()==id){
                boy=b;
                break;
            }
        }
        return boy;
    }

    public ParkingLot getParkingLotById(int id) {
        ParkingLot lot=null;
        for (ParkingLot l:parkingLotList){
            if (l.getId()==id){
                lot=l;
                break;
            }
        }
        return lot;
    }

    public Receipt handleParkingRequset(Car car) {
        boolean haveSite=false;
        for (ParkingLot lot:parkingLotList){
            if (!lot.full()){
                haveSite=true;
                break;
            }
        }
        if (!haveSite){
            return null;
        }
        Receipt receipt=new Receipt();

        Order order=new Order(car,receipt);

        DataBase.insertOrder(order);
        return receipt;
    }
}
