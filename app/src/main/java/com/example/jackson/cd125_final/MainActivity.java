package com.example.jackson.cd125_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import java.util.ArrayList;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity{

    /**
     * Display string for all budgets
     */
    private String budgetList = "";
    /**
     * List of all budgets.
     */
    public ArrayList<Budgets> allBudgets = new ArrayList<>();
    /**
     * Intent object for opening Income.
     */
    private static Intent openIncome;
    /**
     * Intent object for opening Edit.
     */
    private static Intent openEdit;
    /**
     * Creates an instance of IncomeActivity so that it can be closed from non-static context.
     */
    public IncomeActivity callIncome = new IncomeActivity();
    /**
     * Creates an instance of EditActivity so that it can be closed from non-static context.
     */
    public EditActivity callEdit = new EditActivity();


    MainActivity() {
        }

    @Override

    /**
     * Displays activity_main.xml by default
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView budgetText = findViewById(R.id.budgets);

        budgetText.setText(budgetList);


    }

    /**
     * This method is called when the button is pressed, creates an Intent and launches IncomeActivity.
     * @param view is Null.
     */
    public void launchIncomeActivity(View view) {
        openIncome = new Intent(getApplicationContext(), IncomeActivity.class);
        startActivity(openIncome);
    }

    /**
     * This method is called when the button is pressed, creates an Intent and launches EditActivity.
     * @param view Is null.
     */
    public void launchEditActivity(View view) {
        openEdit = new Intent(getApplicationContext(), EditActivity.class);
        startActivity(openEdit);
    }

    /**
     * Closes IncomeActivity or EditActivity when called. Called by the button in both as of rn.
     */
    public void launchHome() {
        callIncome.closeActivity();
        callEdit.closeActivity();
    }

    /**
     * Add a new budget, creates a Budget item and places it in the allBudgets ArrayList.
     */
    public void addNewBudget() {
        EditText inputBudget =  findViewById(R.id.inputBudgetField);
        allBudgets.add(new Budgets(inputBudget.getText().toString(), 0));
        budgetList = getBudgetDisplay();

    }

    private String getBudgetDisplay() {
        String returnBudgets = "";
        for (int i = 0; i < allBudgets.size(); i++) {
            returnBudgets = returnBudgets + allBudgets.get(i).getBudgetName() + "\n";
        }
        return returnBudgets;
    }

}
