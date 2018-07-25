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
}
