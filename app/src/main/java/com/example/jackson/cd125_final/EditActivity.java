package com.example.jackson.cd125_final;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.TextView;
import android.util.Log;


/**
 * All this is for is displaying activity_add_budgets.xml at appropriate times, and closing it.
 */

public class EditActivity extends MainActivity{

    /**
     * Display string for all budgets
     */
    public static String budgetList = " ";


    EditActivity () {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_budgets);


        TextView addBudgetView = findViewById(R.id.budgetAddView);

        addBudgetView.setText(Budgets.printBudgets());



    }

    /**
     * Add a new budget, creates a Budget item and places it in the allBudgets ArrayList. Uses inputs from
     * inputBudget EditText item and inputBudgetAmount edittext item.
     */
    public void addNewBudget(View view) {
        TextInputEditText inputBudget =  (TextInputEditText) findViewById(R.id.inputBudget);
        TextInputEditText inputBudgetAmount =  (TextInputEditText) findViewById(R.id.inputBudgetAmount);
            int budgetAmt = Integer.parseInt(inputBudgetAmount.getText().toString());
            Budgets newBudget = new Budgets(inputBudget.getText().toString(), budgetAmt);
            Log.i("budget", newBudget.getBudgetName());
            Log.i("Budget", "Made new Budget");


        TextView addBudgetView = findViewById(R.id.budgetAddView);
        addBudgetView.setText(Budgets.printBudgets());
        budgetList = Budgets.printBudgets();

    }

    public void main(String[] args) {
    }

    /**
     * Closes activity_add_budgets.xml
     */

    public void launchHomeFromEdit(View view) {

        Log.i("wtf", "fuccin broke");
        Intent openHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openHome);
        finish();
    }
}
