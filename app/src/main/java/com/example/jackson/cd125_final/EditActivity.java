package com.example.jackson.cd125_final;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * All this is for is displaying activity_add_budgets.xml at appropriate times, and closing it.
 */

public class EditActivity extends MainActivity{

    EditActivity () {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_budgets);

        /*
        TextView addBudgetView = findViewById(R.id.budgetAddView);
        addBudgetView.setText("h");
        */

    }

    public void main(String[] args) {
    }

    /**
     * Closes activity_add_budgets.xml
     */
    public void closeActivity() {
        finish();
    }
}
