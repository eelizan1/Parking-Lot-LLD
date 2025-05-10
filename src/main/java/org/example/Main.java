package org.example;

public class Main {
    public static void main(String[] args) {
        ParkingGarage parkingGarage = new ParkingGarage(3, 2);
        ParkingSystem parkingSystem = new ParkingSystem(parkingGarage, 5);

        Driver driver1 = new Driver(1, new Car());
        Driver driver2 = new Driver(2, new Limo());
        Driver driver3 = new Driver(3, new SemiTruck());

        System.out.println(parkingSystem.parkVehicle(driver1));    // true
        System.out.println(parkingSystem.parkVehicle(driver2));    // true
        System.out.println(parkingSystem.parkVehicle(driver3));    // false

        System.out.println(parkingSystem.removeVehicle(driver1));  // true
        System.out.println(parkingSystem.removeVehicle(driver2));  // true
        System.out.println(parkingSystem.removeVehicle(driver3));  // false
    }
}