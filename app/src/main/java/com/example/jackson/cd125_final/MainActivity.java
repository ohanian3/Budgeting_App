package com.example.jackson.cd125_final;




import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.lang.reflect.Type;
import java.util.ArrayList;
import android.widget.TextView;
import android.util.Log;
import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity{


    public static PieChart pieChart;

    /**
     * List of all budgets.
     */
    public static ArrayList<Budgets> allBudgets = new ArrayList<>();
    /**
     * Intent object for opening Income.
     */
    private static Intent openIncome;
    /**
     * Intent object for opening Edit.
     */
    private static Intent openEdit;

    /**
     * Intent object for opening Trans.
     */
    private static Intent openTrans;

    /**
     * Creates an instance of IncomeActivity so that it can be closed from non-static context.
     */
   // public IncomeActivity callIncome = new IncomeActivity();
    /**
     * Creates an instance of EditActivity so that it can be closed from non-static context.
     */
   // public EditActivity callEdit = new EditActivity();


    MainActivity() {
        }

    @Override

    /**
     * Displays activity_main.xml by default
     */
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (readSave("user data") != null) {
            for (Budgets i : readSave("user data")) {
                Budgets j = new Budgets(i);
            }
        }


        TextView addBudgetView = findViewById(R.id.budgetsMain);
        addBudgetView.setText(EditActivity.budgetList);

        setPieChart();

    }

    /**
     * This method is called when the button is pressed, creates an Intent and launches IncomeActivity.
     * @param view is Null.
     */
    public void launchIncomeActivity(View view) {
        openIncome = new Intent(getApplicationContext(), IncomeActivity.class);
        startActivity(openIncome);
    }

    /**
     * This method is called when the button is pressed, creates an Intent and launches IncomeActivity.
     * @param view is Null.
     */
    public void launchTransActivity(View view) {
        openTrans = new Intent(getApplicationContext(), TransActivity.class);
        writeSave("user data");
        startActivity(openTrans);
    }

    /**
     * This method is called when the button is pressed, creates an Intent and launches EditActivity.
     * @param view Is null.
     */
    public void launchEditActivity(View view) {
        openEdit = new Intent(getApplicationContext(), EditActivity.class);
        startActivity(openEdit);
       // writeSave("user data");
    }

    /**
     * Closes IncomeActivity or EditActivity when called. Called by the button in both as of rn.
     */
    public void launchHome() {
        TextView addBudgetView = findViewById(R.id.budgetsMain);
        addBudgetView.setText(EditActivity.budgetList);


        //callIncome.closeActivity();
        //callEdit.closeActivity();
    }





    public static String getBudgetDisplay() {
        return allBudgets.get(0).getBudgetName();
    }

    public void setPieChart() {
        pieChart = (PieChart) findViewById(R.id.piechart_1);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);
        ArrayList<PieEntry> yValues = new ArrayList<>();
        int j = 0;
        int totalSpent = 0;
        ArrayList<Budgets> chartValues = Budgets.getAllBudgets();
        for (Budgets i : chartValues) {
            totalSpent = totalSpent + i.getSpent();
        }

        if (totalSpent == 0) {
            yValues.add(new PieEntry(4f, Budgets.getTotalBudget()));
        } else {
            yValues.add(new PieEntry((Budgets.getTotalBudget() - totalSpent), "Remaining"));
            yValues.add(new PieEntry( totalSpent, "Spent"));
        }


        PieDataSet dataSet = new PieDataSet(yValues, "Budget Overview");
                dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData((dataSet));
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.YELLOW);
        pieChart.setData(pieData);
        //PieChart Ends Here
    }

    public boolean writeSave(String settingName)
    {

        SharedPreferences mSettings = getSharedPreferences("user data", Context.MODE_PRIVATE);
        SharedPreferences.Editor saveEditor = mSettings.edit();

        GsonBuilder gsonb = new GsonBuilder();
        Gson gsonSave = gsonb.create();

        ArrayList<Budgets> save = Budgets.getAllBudgets();

        try {
            String writeValue = gsonSave.toJson(save);
            saveEditor.putString(settingName, writeValue);
            saveEditor.apply();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public ArrayList<Budgets> readSave(String yourSettingName)
    {

        SharedPreferences mSettings = getSharedPreferences("user data", Context.MODE_PRIVATE);

        GsonBuilder gsonb = new GsonBuilder();
        Gson gsonSave = gsonb.create();


        String loadValue = mSettings.getString(yourSettingName, "");
        Type type = new TypeToken<ArrayList<Budgets>>(){}.getType();


        try {
            return gsonSave.fromJson(loadValue, type);
        }
        catch(Exception e) {
            return null;
        }
    }

}
