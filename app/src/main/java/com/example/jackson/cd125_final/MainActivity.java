package com.example.jackson.cd125_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    MainActivity() {
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchIncomeActivity(View view) {
        Intent openIncome = new Intent(getApplicationContext(), IncomeActivity.class);
        startActivity(openIncome);
        setContentView(R.layout.activity_income);

    }



}
