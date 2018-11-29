package com.example.jackson.cd125_final;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * All this is for is displaying activity_add_budgets.xml at appropriate times, and closing it.
 */

public class EditActivity extends AppCompatActivity{
    EditActivity () {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budgets);
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
