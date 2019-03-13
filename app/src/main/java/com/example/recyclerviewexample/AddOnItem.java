package com.example.recyclerviewexample;

public class AddOnItem {
    private String name;
    private long amount;
    private boolean isChecked;

    public AddOnItem(String name, long amount) {
        isChecked = false;
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    public boolean isChecked() {
        return isChecked;
    }
}
