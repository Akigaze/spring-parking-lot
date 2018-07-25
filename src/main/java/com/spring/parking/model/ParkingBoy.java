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
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    public ParkingBoy(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public Receipt park(Car car) {
        for (ParkingLot lot:parkingLots){
            if (!lot.isFull()){
                return lot.park(car);
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

    public boolean isAllParkingLotsFull(){
        for (ParkingLot lot:parkingLots){
            if (!lot.isFull()){
                return false;
            }
        }
        return true;
    }

    public String getParkingLotsInfo() {
        StringBuffer buffer=new StringBuffer();
        buffer.append("|停车场ID|名称|车位|已停车辆|剩余车位|\n");
        buffer.append("======================================\n");
        parkingLots.forEach(lot->{
            String id=lot.getFormatId();
            String name=lot.getName();
            int capacity=lot.getCapacity();
            int carNum=lot.getCarNum();
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
        return parkingLots.stream().map(lot->lot.getCarNum()).reduce(0,(total,current)->total+current);
    }
    private int countSiteNum() {
        return parkingLots.stream().map(lot->lot.getCapacity()).reduce(0,(total,current)->total+current);
    }

    public boolean buildParkingLot(String name, int capacity) {
        return parkingLots.add(new ParkingLot(parkingLots.size()+1,name,capacity));
    }

    private ParkingLot getParkingLotById(int id){
        ParkingLot deleter = null;
        for (ParkingLot lot:parkingLots){
            if (lot.getId()==id){
                deleter=lot;
                break;
            }
        }
        return deleter;
    }
    public boolean deleteParkingLot(int id) {
        ParkingLot deleter=getParkingLotById(id);
        if (deleter==null){
            throw new NotExitParkingLotException();
        }else {
            if (!deleter.hasCar()){
                return parkingLots.remove(deleter);
            }
            return false;
        }
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }
}
