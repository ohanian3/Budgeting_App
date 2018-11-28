package com.example.jackson.cd125_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends AppCompatActivity{

    private static Intent openIncome;
    private static Intent openEdit;
    private static Intent openHome;

    MainActivity() {
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchIncomeActivity(View view) {
        openIncome = new Intent(getApplicationContext(), IncomeActivity.class);
        startActivity(openIncome);
    }

    public void launchEditActivity(View view) {
        openEdit = new Intent(getApplicationContext(), EditActivity.class);
        startActivity(openEdit);
    }

    public void launchHome() {
        openHome = new Intent(getApplicationContext(), EditActivity.class);
        startActivity(openHome);
    }

}
