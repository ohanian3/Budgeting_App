package com.example.jackson.cd125_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * Budget Objects here.
 *
 */
public class Budgets extends AppCompatActivity{
    /**
     * The budget name.
     */
    private String budgetName = "";

    /**
     * The budget amount.
     */
    private int budgetAmount = 0;

    /**
     * Map of all budgets sorted by name.
     */
    public static Map allBudgets = new HashMap<String, Budgets>();

    /**
     * ArrayList all budgets.
     */
    private static ArrayList<Budgets> budgetArr = new ArrayList<>();
    Budgets () {

    }

    Budgets (String type) {
        budgetName = type;
    }

    Budgets (String type, int amount) {
        allBudgets.put(type, this);
        budgetArr.add(this);
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

    public static ArrayList<Budgets> getAllBudgets() {
        return budgetArr;
    }

    public static String printBudgets() {
        String ret = "Budgets - \n";
        for(int i = 0; i < budgetArr.size(); i++) {
            ret = ret + budgetArr.get(i).getBudgetName() + ":  " + budgetArr.get(i).getBudgetAmount() + "\n ";
        }
        return ret;
    }

    public static int getTotalBudget() {
        int ret = 0;
        for(int i = 0; i < budgetArr.size(); i++) {
            ret = ret + budgetArr.get(i).getBudgetAmount();
        }
        return ret;
    }

}