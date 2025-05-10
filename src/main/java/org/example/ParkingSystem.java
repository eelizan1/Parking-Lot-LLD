package org.example;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    private ParkingGarage parkingGarage;
    private int hourlyRate;
    private Map<Integer, Integer> timeParked; // maps driverId to the time they parked at

    // we can specify the hourly rate here
    public ParkingSystem(ParkingGarage parkingGarage, int hourlyRate) {
        this.parkingGarage = parkingGarage;
        this.hourlyRate = hourlyRate;
        this.timeParked = new HashMap<>();
    }

    public boolean parkVehicle(Driver driver) {
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        // attempt to park the vehicle - could return false if no spots
        boolean canBeParked = parkingGarage.parkVehicle(driver.getVehicle());
        // if we can park then set the driver and the time in the map
        if (canBeParked) {
            timeParked.put(driver.getId(), currentHour);
        }

        return canBeParked;
    }

    public boolean removeVehicle(Driver driver) {
        // check if vehicle is in time map
        if (!timeParked.containsKey(driver.getId())) {
            return false;
        }

        // get the amount due for driver
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int timeParked = (int) Math.ceil(currentHour - this.timeParked.get(driver.getId()));

        // charge the driver
        driver.charge(timeParked * hourlyRate);
        return parkingGarage.removeVehicle(driver.getVehicle());
    }
}
