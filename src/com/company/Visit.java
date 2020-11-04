package com.company;

public class Visit {
    private String date;
    private int visits;

    public Visit(String date, int visits) {
        this.date = date;
        this.visits = visits;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
