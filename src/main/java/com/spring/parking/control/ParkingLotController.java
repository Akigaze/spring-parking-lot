package com.spring.parking.control;

import com.spring.parking.model.*;
import com.spring.parking.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingLotController {
    @Autowired
    private ParkingLotService service;

    @GetMapping("/parkinglots")
    public List<ParkingLot> showParkingLots(){
        return service.getParkingLotList();
    }

    @GetMapping("/parkingboys")
    public List<ParkingBoy> showParkingBoys(){
        return service.getBoyList();
    }

    @GetMapping("/parkingboys/{id}")
    public ParkingBoy selectParkingBoy(@PathVariable int id){
        return service.getParkingBoyById(id);
    }

    @GetMapping("/parkinglots/{id}")
    public ParkingLot selectParkingLot(@PathVariable int id){
        return service.getParkingLotById(id);
    }

    @PostMapping("/parkinglots")
    public ParkingLot addParkingLot(@RequestBody ParkingLot newLot){
        return service.buildParkingLot(newLot);
    }

    @PostMapping("/parkingboys")
    public ParkingBoy addParkingBoy(@RequestBody ParkingBoy boy){
        return service.hireParkingBoy(boy);
    }

    @PostMapping("/parkingboys/{boyID}/parkinglots")
    public void assignParkingLotToParkingBoy(@PathVariable int boyID,@RequestBody ParkingLot lot){
        service.assignParkingLotToParkingBoy(boyID,lot.getId());
    }

    @PostMapping("/receipts")
    public Receipt parkingCar(@RequestBody Car car){
        return service.handleParkingRequset(car);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam(defaultValue = "") String status){
        if (status.equals("")){
            return service.getOrderList();
        }else {
            return service.getOrderListByStatus(status);
        }
    }

    @GetMapping("/orders/{orderID}")
    public Order getOrderById(@PathVariable int orderID){
            return service.getOrderById(orderID);
    }

    @GetMapping("/parkingboys/{boyID}/parkinglots")
    public List<ParkingLot> getParkingLotOfParkingBoy(@PathVariable int boyID){
        return service.getParkingLotByBoyId(boyID);
    }

    @PutMapping("/parkingboys/{boyID}/orders")
    public boolean processOrder(@PathVariable int boyID,@RequestBody Order order){
        return service.processOrderByParkingBoy(boyID,order);
    }

    @GetMapping("/receipts/{id}")
    public Car pickUpCar(@PathVariable String id){
        return service.processReceipt(id);
    }
}
