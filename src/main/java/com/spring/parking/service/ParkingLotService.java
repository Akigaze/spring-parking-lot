package com.spring.parking.service;

import com.spring.parking.db.DataBase;
import com.spring.parking.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotService {


    private List<ParkingLot> parkingLotList=new ArrayList<>();
    private List<ParkingBoy> boyList=new ArrayList<>();
    private List<Order> orderList=new ArrayList<>();

    public ParkingLotService() {
    }

    public ParkingLotService(List<ParkingLot> parkingLotList, List<ParkingBoy> boyList) {
        this.parkingLotList = parkingLotList;
        this.boyList = boyList;
    }

    public List<ParkingLot> getParkingLotList() {
        return DataBase.getParkingLotList();
    }


    public List<ParkingBoy> getBoyList() {
        return DataBase.getBoyList();
    }

    public ParkingLot buildParkingLot(ParkingLot newLot) {
        DataBase.insertParkingLot(newLot);
        return newLot;
    }

    public ParkingBoy hireParkingBoy(ParkingBoy newer) {
        DataBase.insertParkingBoy(newer);
        return newer;
    }


    public void assignParkingLotToParkingBoy(int boyID, int lotID) {
        ParkingLot lot=DataBase.getParkingLotList().stream().filter(l->l.getId()==lotID).findFirst().get();
        ParkingBoy boy=DataBase.getBoyList().stream().filter(b->b.getId()==boyID).findFirst().get();
        if (!boy.getParkingLots().contains(lot)){
            boy.getParkingLots().add(lot);
        }
    }

    public ParkingBoy getParkingBoyById(int id) {
        ParkingBoy boy=null;
        for (ParkingBoy b:DataBase.getBoyList()){
            if (b.getId()==id){
                boy=b;
                break;
            }
        }
        return boy;
    }

    public ParkingLot getParkingLotById(int id) {
        ParkingLot lot=null;
        for (ParkingLot l:DataBase.getParkingLotList()){
            if (l.getId()==id){
                lot=l;
                break;
            }
        }
        return lot;
    }

    public Receipt handleParkingRequset(Car car) {

        boolean haveSite=false;
        for (ParkingLot lot:DataBase.getParkingLotList()){
            if (!lot.full()){
                haveSite=true;
                break;
            }
        }
        if (!haveSite){
            return null;
        }
        Receipt receipt=new Receipt();

        Order order=new Order(DataBase.getOrderList().size()+1,car,receipt);

        DataBase.insertOrder(order);
        return receipt;
    }

    public List<Order> getOrderList() {
        return DataBase.getOrderList();
    }

    public List<Order> getOrderListByStatus(String status) {
        return DataBase.getOrderList().stream().filter(o->o.getStatus().equals(status)).collect(Collectors.toList());
    }

    public List<ParkingLot> getParkingLotByBoyId(int boyID) {
        List<ParkingLot> lotList=null;
        for (ParkingBoy boy:DataBase.getBoyList()){
            if (boy.getId()==boyID){
                lotList=boy.getParkingLots();
                break;
            }
        }
        return lotList;
    }

    public boolean processOrderByParkingBoy(int boyID, Order order) {
        Order realOrder=DataBase.getOrderList().stream().filter(o->o.getId()==order.getId()).findFirst().get();
        if (realOrder.getStatus()=="deal"){
            return false;
        }
        ParkingBoy boy=DataBase.getBoyList().stream().filter(b->b.getId()==boyID).findFirst().get();
        if (boy.allParkingLotsFull()){
            return false;
        }
        boy.park(realOrder.getParkedCar(),realOrder.getReceipt());
        realOrder.setStatus("deal");
        return true;
    }

    public Order getOrderById(int orderID) {
        Order order=null;
        for (Order o:DataBase.getOrderList()){
            if (o.getId()==orderID){
                order=o;
                break;
            }
        }
        return order;
    }

    public Car processReceipt(String id) {
        for (ParkingLot lot:DataBase.getParkingLotList()){
            if (lot.containsReceipt(id)){
                return lot.unpark(new Receipt(id));
            }
        }
        return null;
    }
}
