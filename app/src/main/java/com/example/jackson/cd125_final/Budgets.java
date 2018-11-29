package com.example.jackson.cd125_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Budgets I plan to be objects for each budget set. So like if you have a gas category or food or
 * whatever make it a budget. My hope was we could then store total spending in here as well. Theres
 * an array list in MainActivity to hold them all so on main screen we could display each budget and
 * total usage.
 *
 * Right now these are getting created when the new budget button is pressed in EditActivity but
 * it doesn't actually do anything yet.
 *
 */
public class Budgets extends AppCompatActivity{
    private String budgetName = "";
    private int budgetAmount = 0;

    Budgets () {

    }
    Budgets (String type) {
        budgetName = type;
    }
    Budgets (String type, int amount) {
        budgetName = type;
        budgetAmount = amount;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    /**
     * Getters and Setters.
     */
    public int getBudgetAmount() {
        return budgetAmount;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String setName) {
        budgetName = setName;
    }

    public void setBudgetAmount(int setAmount) {
        budgetAmount = setAmount;
    }


}