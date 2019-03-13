package com.example.recyclerviewexample;

public class SelectableItem extends AddOnItem{
    private boolean isSelected = false;


    public SelectableItem(AddOnItem item,boolean isSelected) {
        super(item.getName(),item.getAmount());
        this.isSelected = isSelected;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
