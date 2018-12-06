package com.example.jackson.cd125_final;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * All this is for is displaying activity_income.xml at appropriate times, and closing it.
 */
public class IncomeActivity extends MainActivity{

    IncomeActivity () {
        Log.i("this", "made IncomeActivity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        makePieChart();
    }

    public void main(String[] args) {
    }

    /**
     * Closes activity_income.xml.
     */
    public void launchHomeFromIncome(View view) {
        Intent openHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openHome);
        finish();
    }

    // open source third-party library for making interactive pie charts
    public void makePieChart() {
        PieChart pieChart = findViewById(R.id.piechart_income);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);
        ArrayList<PieEntry> yValues = new ArrayList<>();

        int j = 0;
        ArrayList<Budgets> chartValues = Budgets.getAllBudgets();
        double budgetTotal = (double) Budgets.getTotalBudget();
        double percentOfBudget = 0.0;

        for (Budgets i : chartValues) {
            percentOfBudget = ((double) i.getBudgetAmount() / budgetTotal) * 100.0;
            yValues.add(new PieEntry((int) percentOfBudget,i.getBudgetName()));
        }



        PieDataSet dataSet = new PieDataSet(yValues, "Your Budget");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData((dataSet));
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.YELLOW);
        pieChart.setData(pieData);
    }


}
