package com.example.jackson.cd125_final;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class IncomeActivity extends AppCompatActivity{
    public char incomeInt;

    public static void main(String[] unused) {
        onOpenIncome();
    }

    public void onOpenIncome() {
        setContentView(R.layout.activity_income);
        //EditText incomeInput = new EditText(findViewById(R.id("input_income")));
    }
}
