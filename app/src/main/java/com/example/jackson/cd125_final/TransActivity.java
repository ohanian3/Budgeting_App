package com.example.jackson.cd125_final;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class TransActivity extends MainActivity{

    /**
     * List of all radioButtons
     */
    ArrayList<RadioButton> radioBtnList = new ArrayList<>();

    /**
     * List of all Budgets selected
     */
    ArrayList<Budgets> budgetList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.trans_layout);

        // This makes the # of radio buttons
        for (int i = 0; i < Budgets.getAllBudgets().size(); i++) {
            radioBtnList.add(new RadioButton(this));
            LinearLayout layout = findViewById(R.id.rbLayout);
            layout.addView(radioBtnList.get(i));
            radioBtnList.get(i).setText(Budgets.getAllBudgets().get(i).getBudgetName());
        }


    }

    /**
     * Closes trans_layout.xml.
     */
    public void launchHomeFromTrans(View view) {
        Intent openHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openHome);
        finish();
    }

    public void addTrans(View view) {
        TextInputEditText inputBudgetAmount =  (TextInputEditText) findViewById(R.id.inputTrans);
        int trans = Integer.parseInt(inputBudgetAmount.getText().toString());

        int index = 0;

        for (RadioButton i : radioBtnList) {
            if (i.isChecked()) {
                index = radioBtnList.indexOf(i);
                budgetList.add(Budgets.getAllBudgets().get(index));

                budgetList.get(index).addTrans(trans);

            }
        }




    }
}
