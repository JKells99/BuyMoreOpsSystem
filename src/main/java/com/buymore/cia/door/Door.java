package com.buymore.cia.door;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Door {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doorNumber;
    private String doorType;
    private String doorStatus;

    public Door(int doorNumber, String doorType, String doorStatus) {
        this.doorNumber = doorNumber;
        this.doorType = doorType;
        this.doorStatus = doorStatus;
    }

    public Door() {
    }


    public long getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(long doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getDoorType() {
        return doorType;
    }

    public void setDoorType(String doorType) {
        this.doorType = doorType;
    }

    public String getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(String doorStatus) {
        this.doorStatus = doorStatus;
    }

    @Override
    public String toString() {
        return "Door: Door Number: " + doorNumber + " " +
                "Door Status: " + doorStatus;
    }
}
