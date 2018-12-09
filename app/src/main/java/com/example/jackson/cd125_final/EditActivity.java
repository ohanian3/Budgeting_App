package com.example.jackson.cd125_final;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;


/**
 * All this is for is displaying activity_add_budgets.xml at appropriate times, and closing it.
 */

public class EditActivity extends MainActivity{

    /**
     * Display string for all budgets
     */
    public static String budgetList = " ";

    /**
     * List of all radioButtons
     */
    ArrayList<RadioButton> radioBtnList = new ArrayList<>();


    EditActivity () {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_budgets);




        for (int i = 0; i < Budgets.getAllBudgets().size(); i++) {
            radioBtnList.add(new RadioButton(this));
            LinearLayout layout = findViewById(R.id.selectBudget);
            layout.addView(radioBtnList.get(i));
            radioBtnList.get(i).setText(Budgets.getAllBudgets().get(i).getBudgetName());
        }



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
        InputMethodManager goAwayKeyboard = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        goAwayKeyboard.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        for (int i = 0; i < Budgets.getAllBudgets().size(); i++) {
            radioBtnList.add(new RadioButton(this));
            LinearLayout layout = findViewById(R.id.selectBudget);
            layout.addView(radioBtnList.get(i));
            radioBtnList.get(i).setText(Budgets.getAllBudgets().get(i).getBudgetName());
        }


        budgetList = Budgets.printBudgets();

    }

    public void main(String[] args) {
    }

    /**
     * Closes activity_add_budgets.xml
     */

    public void launchHomeFromEdit(View view) {
        Intent openHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openHome);
        finish();
    }

    public void deleteSelected(View view) {
        int index = 0;
        for (RadioButton i : radioBtnList) {
            if (i.isSelected()) {
                index = radioBtnList.indexOf(i);
                Budgets.removeBudget(Budgets.getAllBudgets().get(index));
            }
        }
    }
}
