package com.android.kusitms.kbscilpoon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class StatisticActivity extends AppCompatActivity {


    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_statistics);

        pieChart = (PieChart)findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.BLACK);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(33f,"카페/간식"));
        yValues.add(new PieEntry(21f,"식사"));
        yValues.add(new PieEntry(17f,"교통/차량"));
        yValues.add(new PieEntry(8f,"백화점/쇼핑"));
        yValues.add(new PieEntry(5f,"출금"));
        yValues.add(new PieEntry(5f,"술/유흥"));
        yValues.add(new PieEntry(4f,"생활/마트"));
        yValues.add(new PieEntry(3f,""));
        yValues.add(new PieEntry(2f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));

        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setEntryLabelColor(Color.BLACK);

        Description description = new Description();
        description.setText("세계 국가"); //라벨
        description.setTextSize(15);
        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"Countries");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);

    }

}

