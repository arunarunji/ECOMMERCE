package com.model;



public class Address {
    private final int doorNo;
    private final String street;
    private final String area;
    private final String city;
    private final String state;
    private final int pinCode;

    public Address(int doorNo, String street, String area, String city, String state, int pinCode) {
        this.doorNo = doorNo;
        this.street = street;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "DOOR_NO=" + doorNo +
                ", STREET='" + street + '\'' +
                ", AREA='" + area + '\'' +
                ", CITY='" + city + '\'' +
                ", STATE='" + state + '\'' +
                ", PIN_CODE=" + pinCode +
                '}';
    }
}




