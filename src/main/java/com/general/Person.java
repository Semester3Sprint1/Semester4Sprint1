package com.general;

public  abstract class Person {
    private String firstName;
    private String lastName;
    private Address address;
    private String email;


    public Person(String firstName, String lastName, Address address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return(firstName + " " + lastName);
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override

    public String toString(){
        return( "Name: " + getName() + "\nAddress: " + getAddress() + "\nEmail: " +getEmail() );
    }
}
