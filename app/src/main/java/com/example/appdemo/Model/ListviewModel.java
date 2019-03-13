package com.example.appdemo.Model;

import java.io.Serializable;

public class ListviewModel implements Serializable {
    private int Id;
    private String Username;
    private String PhoneNumber;
    private String Address;

    public ListviewModel(int mId, String mUsername, String mPhoneNumber, String mAddress) {
        Id = mId;
        Username = mUsername;
        PhoneNumber = mPhoneNumber;
        Address = mAddress;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
