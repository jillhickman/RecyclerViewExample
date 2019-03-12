package com.example.recyclerviewexample;

public class AddOnItem {
    private String name;
    private long amount;

    public AddOnItem(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }
}
