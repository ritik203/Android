package com.example.recycle;

public class Contacts {

    int img;
    String name,number;

    public Contacts() {
    }

    public Contacts(int img, String name, String number) {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
