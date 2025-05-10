package org.example;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    // spots for vehicles
    private int[] spots;
    // keep track of which vehicles are parked in which spots,
    // where [left, right] represents the range of spots represented as the array indexes occupied by a vehicle.
    private Map<Vehicle, int[]> vehicleMap;

    public ParkingFloor(int spotCount) {
        this.spots = new int[spotCount]; // initialize spot count
        this.vehicleMap = new HashMap<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        int size = vehicle.getSpotSize(); // get how many consecutive spots this vehicle needs
        int left = 0; // start index of a potential parking block
        int right = 0; // end index of a potential parking block

        // Use a sliding window to find a continuous block of 'size' empty spots
        while (right < spots.length) {

            // If the current spot is occupied, shift the window
            if (spots[right] != 0) {
                // Move left pointer to the next spot after the current 'right' since right is 1
                left = right + 1;
            }
            // Check if the current window size equals the vehicle's required size
            // ex. limo -> [0, 0, 1] limo can fit in the first and second index since it equals its size
            if (right - left + 1 == size) {
                // We've found a valid block, mark the spots as occupied going through the window between left and right
                for (int k = left; k <= right; k++) {
                    spots[k] = 1; // mark spot as occupied
                }
                // Record which spots this vehicle is occupying in the vehicle map
                vehicleMap.put(vehicle, new int[]{left, right});

                return true; // parking successful
            }
            // Move the end of the window forward to keep searching
            right++;
        }

        // No valid parking block was found
        return false;
    }

    public void removeVehicle(Vehicle vehicle) {
        int[] position = vehicleMap.get(vehicle); // contains the start and end pointer in the spots array
        int left = position[0];
        int right = position[1];

        // go through array and mark as 0 for available
        for (int i = left; i <= right; i++) {
            this.spots[i] = 0;
        }

        // remove from map
        vehicleMap.remove(vehicle);
    }

    public int[] getParkingSpots() {
        return spots;
    }

    // used to check if there's a vehicle in ths floor
    public int[] getVehicleSpots(Vehicle vehicle) {
        return vehicleMap.get(vehicle);
    }
}
