package utils;

public class TestData {

    private String destination;
    private String checkInDate;
    private String checkOutDate;

    // Constructor
    public TestData(String destination, String checkInDate, String checkOutDate) {
        this.destination = destination;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;


    }

    // Getters
    public String getDestination() {
        return destination;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "TestData{destination=" + destination + ", checkInDate='" + checkInDate + "', checkOutDate=" + checkOutDate + "'}";
    }
}

