package com.example.jackson.cd125_final;

import java.util.ArrayList;

public class Transaction {

    private int amount;

    private String tag = "";

    private static ArrayList<Transaction> allTrans = new ArrayList<>();

    Transaction(String setTag, int setAmount) {
        this.tag = setTag;
        this.amount = setAmount;
        allTrans.add(this);
    }

    public String getTag() {
        return this.tag;
    }

    public int getAmount() {
        return this.amount;
    }

    public static ArrayList<Transaction> getAllTrans() {
        return allTrans;
    }
}
