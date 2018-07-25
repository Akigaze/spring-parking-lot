package com.spring.parking.control;

import com.spring.parking.model.ParkingBoy;
import com.spring.parking.model.ParkingLot;
import com.spring.parking.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/parkinglots")
    public ParkingLot addParkingLot(@RequestBody ParkingLot newLot){
        return service.buildParkingLot(newLot);
    }

    @PostMapping("/parkingboys")
    public ParkingBoy addParkingBoy(@RequestBody ParkingBoy boy){
        return service.hireParkingBoy(boy);
    }
}
