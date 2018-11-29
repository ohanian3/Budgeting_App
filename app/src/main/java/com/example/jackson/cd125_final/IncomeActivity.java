package com.example.jackson.cd125_final;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * All this is for is displaying activity_income.xml at appropriate times, and closing it.
 */
public class IncomeActivity extends AppCompatActivity{
    IncomeActivity () {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
    }

    public void main(String[] args) {
    }

    /**
     * Closes activity_income.xml.
     */
    public void closeActivity() {
        finish();
    }


}
