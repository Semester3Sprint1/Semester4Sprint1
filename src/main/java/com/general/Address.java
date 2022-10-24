package com.general;

public class Address {

    private static int addressID = 0;
    private  String streetAddress;
    private String city;
    private String postalCode;
    private String province;
    private String country;


    public Address( String streetAddress,String city, String postalCode, String province, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;

        addressID++;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return("Street Address:" + getStreetAddress()
                + "\n" + "City,"
                + getCity()
                + ",Province:"
                + getProvince()
                + ",Country"
                + getCountry()
                + "Postal Code"
                + getPostalCode());

    }
}
