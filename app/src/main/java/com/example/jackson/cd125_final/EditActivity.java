package com.example.jackson.cd125_final;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class EditActivity extends AppCompatActivity{
    EditActivity () {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budgets);
    }

    public void main(String[] args) {
        setContentView(R.layout.activity_income);
    }

}
