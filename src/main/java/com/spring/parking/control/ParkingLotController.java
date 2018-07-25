package com.spring.parking.control;

import com.spring.parking.model.ParkingBoy;
import com.spring.parking.model.ParkingLot;
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
    public void assignParkingLotToParkingBoy(@RequestParam(defaultValue="0") int id,@PathVariable int boyID,@RequestBody ParkingLot lot){
        int lotID=id;
        if (id==0&&lot.getId()!=0){
            lotID=lot.getId();
        }
        service.assignParkingLotToParkingBoy(boyID,lotID);
    }
}
