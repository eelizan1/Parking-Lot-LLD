package org.example;

public class ParkingGarage {
    private ParkingFloor[] parkingFloors; // hold an array of parking floors

    public ParkingGarage(int floorCount, int spotsPerFloor) {
        parkingFloors = new ParkingFloor[floorCount]; // set how many floors/levels
        // for each floor, set the number of spots per floor
        for (int i = 0; i < floorCount; i++) {
            parkingFloors[i] = new ParkingFloor(spotsPerFloor);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        // go through the floors see if we can park the vehicle at in open spot
        for (ParkingFloor floor : parkingFloors) {
            if (floor.parkVehicle(vehicle)) {
                return true;
            }
        }

        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        // find the vehicle from the floors
        for (ParkingFloor floor : parkingFloors) {
            if (floor.getVehicleSpots(vehicle) != null) {
                floor.removeVehicle(vehicle);
                return true;
            }
        }

        return false;
    }
}
