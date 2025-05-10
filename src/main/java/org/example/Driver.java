package org.example;

public class Driver {
    private int id;
    private int paymentDue;
    private Vehicle vehicle;

    public Driver(int id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
        this.paymentDue = 0; // start at 0 and will increase as driver gets charged
    }

    public void charge(int amount) {
        this.paymentDue += amount;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
