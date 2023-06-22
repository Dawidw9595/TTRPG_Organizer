package com.example.rollapp;

public class RollData {
    private int id;
    private String person;
    private int number;
    private String dateTime;

    public RollData(int id, String person, int number, String dateTime) {
        this.id = id;
        this.person = person;
        this.number = number;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getPerson() {
        return person;
    }

    public int getNumber() {
        return number;
    }

    public String getDateTime() {
        return dateTime;
    }
}