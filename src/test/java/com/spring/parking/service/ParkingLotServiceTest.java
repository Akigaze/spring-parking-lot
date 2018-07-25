package com.spring.parking.service;

import com.spring.parking.model.ParkingBoy;
import com.spring.parking.model.ParkingLot;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ParkingLotServiceTest {
    @Test
    public void should_add_a_new_ParkingLot_when_call_buildParkingLot(){
        ParkingLot newLot=mock(ParkingLot.class);
        ParkingLotService service=new ParkingLotService();

        service.buildParkingLot(newLot);

        assertThat(service.getParkingLotList().contains(newLot),is(true));
    }

    @Test
    public void should_add_a_new_ParkingBoy_when_call_hireParkingBoy(){
        ParkingBoy tom=mock(ParkingBoy.class);
        ParkingLotService service=new ParkingLotService();

        service.hireParkingBoy(tom);

        assertThat(service.getBoyList().contains(tom),is(true));
    }

    @Test
    public void should_assign_the_specific_ParkingBoy_to_charge_a_parkinglot_when_call_assignParkingLotToParkingBoy(){
        ParkingBoy tom=new ParkingBoy(1,"Tom");
        ParkingLot lot=new ParkingLot(1,"东门停车场",2);

        ParkingLotService service=new ParkingLotService();
        service.buildParkingLot(lot);
        service.hireParkingBoy(tom);

        service.assignParkingLotToParkingBoy(1,1);

        assertThat(tom.getParkingLots().contains(lot),is(true));
    }
}
