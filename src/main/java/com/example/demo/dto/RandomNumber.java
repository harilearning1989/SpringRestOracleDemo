package com.example.demo.dto;

public class RandomNumber {

    private int id;
    private String rowId;

    public RandomNumber(){

    }
    public RandomNumber(int id, String rowId) {
        this.id = id;
        this.rowId = rowId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
}
