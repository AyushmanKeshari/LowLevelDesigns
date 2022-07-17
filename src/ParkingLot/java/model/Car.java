package ParkingLot.java.model;

public class Car {
    private String registrationID;
    private String color;

    public Car(String registrationID, String color) {
        this.registrationID = registrationID;
        this.color = color;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public String getColor() {
        return color;
    }
}
