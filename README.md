# Parking-Lot-LLD

# Final Requirements

- Multiple Floors
    - A single floor could have variable number of parking spots
- Vehicle Types required -  Car, Limos, Semi-trucks
    - Car will take up 1 parking spot
    - Limo will take up 2 consecutive parking spots
    - Semi-truck will take up 3 consecutive parking spots
- Payment system - Driver will be charged for the time in hours that they were there
    - *Payment system will assign them the next available parking spot in the lowest floor possible*
    
    **Assignment of Vehicle Logic** - Triggered by Payment System
    
    - Payment system will assign them the next available parking spot in the lowest floor possible
    - A floor will have n spots starting from 1 to n and we’ll start assigning spots starting at 1
    - If we run out of capacity from all of the floors the payment system should not trigger the assignment
