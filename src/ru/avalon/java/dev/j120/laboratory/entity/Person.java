
package ru.avalon.java.dev.j120.laboratory.entity;


public class Person {
    private String contactPerson;
    private String deliveryAddress;
    private String phoneNumber;

    public Person(String contactPerson, String deliveryAddress, String phoneNumber) {
        this.contactPerson = contactPerson;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }  
}
