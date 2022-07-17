package ParkingLot.java;

public class OutputPrinter {

    public void welcome() {
        printWithNewLine("Welcome to Ayushman's Parking lot");
    }

    public void end() {
        printWithNewLine("Thanks for using Ayushman's Parking lot service");
    }

    public void fileNotFound() {
        printWithNewLine("File not found");
    }

    public void notFound() {
        printWithNewLine("Not found");
    }

    public void parkingLotFull() {
        printWithNewLine("Sorry, Parking lot is full.");
    }

    public void parkingLotEmpty() {
        printWithNewLine("Parking lot is empty.");
    }

    public void statusHeader() {
        printWithNewLine("Slot No.      Registration No         Colour");
    }

    public void printWithNewLine(String message) {
        System.out.println(message);
    }
}
