package com.spring.parking.model;

import com.spring.parking.model.exception.AllParkingLotsFullException;
import com.spring.parking.model.exception.InvalidReceiptException;
import com.spring.parking.model.exception.NotExitParkingLotException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ParkingBoy {
    private int id;
    private String name;
    private List<ParkingLot> parkingLots=new ArrayList<>();

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    public ParkingBoy(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car,Receipt receipt) {
        for (ParkingLot lot:parkingLots){
            if (!lot.full()){
                return lot.park(car,receipt);
            }
        }
        throw new AllParkingLotsFullException();
    }

    public Car unPark(Receipt card){
        for (ParkingLot lot:parkingLots){
            if(lot.containsReceipt(card)){
                return lot.unpark(card);
            }
        }
        throw new InvalidReceiptException();
    }

    public boolean allParkingLotsFull(){
        for (ParkingLot lot:parkingLots){
            if (!lot.full()){
                return false;
            }
        }
        return true;
    }

    public String generateParkingLotsInfo() {
        StringBuffer buffer=new StringBuffer();
        buffer.append("|停车场ID|名称|车位|已停车辆|剩余车位|\n");
        buffer.append("======================================\n");
        parkingLots.forEach(lot->{
            String id=lot.formatId();
            String name=lot.getName();
            int capacity=lot.getCapacity();
            int carNum=lot.countCarNumber();
            int restSites=capacity-carNum;
            String item=String.format("|%s|%s|%d(个)|%d(辆)|%d(个)|\n",id,name,capacity,carNum,restSites);
            buffer.append(item);
        });
        buffer.append("\n");
        buffer.append(String.format("总车位：%d(个)\n",countSiteNum()));
        buffer.append(String.format("停车总量：%d（辆）\n",countCarNum()));
        buffer.append(String.format("总剩余车位：%d（个）",countSiteNum()-countCarNum()));

        return buffer.toString();
    }

    private int countCarNum() {
        return parkingLots.stream().map(lot->lot.countCarNumber()).reduce(0,(total, current)->total+current);
    }
    private int countSiteNum() {
        return parkingLots.stream().map(lot->lot.getCapacity()).reduce(0,(total,current)->total+current);
    }
}
