package com.sam.test.climacon;

/**
 * Created by sagar on 9/20/2017.
 */

public class Data {
    String id;
    String name;
    String address;
    String phone;
    public Data(){

    }

    public Data(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;

    }

    public  String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
}
