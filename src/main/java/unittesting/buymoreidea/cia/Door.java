package unittesting.buymoreidea.cia;

public class Door {
    private int doorNumber;
    private String doorType;
    private String doorStatus;

    public Door(int doorNumber, String doorType, String doorStatus) {
        this.doorNumber = doorNumber;
        this.doorType = doorType;
        this.doorStatus = doorStatus;
    }

    public Door() {
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
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
        return "Door{" +
                "doorNumber=" + doorNumber +
                ", doorType='" + doorType + '\'' +
                ", doorStatus='" + doorStatus + '\'' +
                '}';
    }
}
