package model;

/**
 * Created by bijay on 11/28/2016.
 */

public class Hotels {
    private int hotel_id;
    private String hotels_name;
    private String location;
    private String booking_status;

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotels_name() {
        return hotels_name;
    }

    public void setHotels_name(String hotels_name) {
        this.hotels_name = hotels_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
    }
}
