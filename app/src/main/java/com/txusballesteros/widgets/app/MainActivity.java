/*
 * Copyright Txus Ballesteros 2015 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */
package com.txusballesteros.widgets.app;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.txusballesteros.widgets.FitChart;
import com.txusballesteros.widgets.FitChartValue;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.txusballesteros.widgets.app.R.id.line1;

public class MainActivity extends AppCompatActivity {


    private LineChart canvas;

    private void setData(){

        List<Entry> entries1 = new ArrayList<>();
        List<Entry> entries2 = new ArrayList<>();
        List<Entry> entries3 = new ArrayList<>();

        List<String> labels;

        LineDataSet prePrimary, primary, secondary;

        entries1.add(new Entry(1, 5));
        entries1.add(new Entry(2, 33));
        entries1.add(new Entry(3, 35));
        entries1.add(new Entry(4, 21));
        entries1.add(new Entry(5, 15));

        entries2.add(new Entry(1, 10));
        entries2.add(new Entry(2, 23));
        entries2.add(new Entry(3, 15));
        entries2.add(new Entry(4, 20));
        entries2.add(new Entry(5, 25));

        entries3.add(new Entry(1, 13));
        entries3.add(new Entry(2, 36));
        entries3.add(new Entry(3, 14));
        entries3.add(new Entry(4, 40));
        entries3.add(new Entry(5, 43));

        prePrimary = new LineDataSet(entries1,"Pre-Primary");
        prePrimary.setLineWidth(7f);
        prePrimary.setCircleHoleRadius(5f);
        prePrimary.setColor(Color.parseColor("#b6e9ed"));
        prePrimary.setCircleColor(Color.parseColor("#b6e9ed"));
        prePrimary.setCircleRadius(10f);
        prePrimary.setDrawValues(false);

        primary = new LineDataSet(entries2,"Primary");
        primary.setLineWidth(7f);
        primary.setCircleRadius(10f);
        primary.setCircleHoleRadius(5f);
        primary.setColor(Color.parseColor("#73e1ff"));
        primary.setCircleColor(Color.parseColor("#73e1ff"));
        primary.setDrawValues(false);

        secondary = new LineDataSet(entries3,"Secondary");
        secondary.setLineWidth(7f);
        secondary.setCircleRadius(10f);
        secondary.setCircleHoleRadius(5f);
        secondary.setColor(Color.parseColor("#99c6d3"));
        secondary.setCircleColor(Color.parseColor("#99c6d3"));
        secondary.setDrawValues(false);


        labels = new ArrayList<String>();

        labels.add("M");
        labels.add("T");
        labels.add("W");
        labels.add("T");
        labels.add("F");
        labels.add("S");

        LineData data = new LineData(prePrimary,primary,secondary);
        canvas.setData(data);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        canvas = (LineChart) findViewById(R.id.lines);
        canvas.animateX(1000);

        setData();

        canvas.setBackgroundColor(Color.WHITE);
        canvas.getAxisLeft().setDrawGridLines(false);
        canvas.getXAxis().setDrawGridLines(false);
        canvas.getXAxis().setEnabled(false);

        canvas.setDrawBorders(false);
        canvas.getAxisLeft().setDrawAxisLine(false);
        canvas.getAxisRight().setDrawAxisLine(false);

        canvas.getDescription().setEnabled(false);

        // if disabled, scaling can be done on x- and y-axis separately
        canvas.setPinchZoom(false);



        final FitChart fitChart1 = (FitChart)findViewById(R.id.Chart1);
        fitChart1.setMinValue(0f);
        fitChart1.setMaxValue(100f);

        final FitChart fitChart2 = (FitChart)findViewById(R.id.Chart2);
        fitChart2.setMinValue(0f);
        fitChart2.setMaxValue(100f);

        final FitChart fitChart3 = (FitChart)findViewById(R.id.Chart3);
        fitChart3.setMinValue(0f);
        fitChart3.setMaxValue(100f);



        Resources resources = getResources();

        fitChart2.setValue(45);
        fitChart3.setValue(15);

                Collection<FitChartValue> values = new ArrayList<>();
                values.add(new FitChartValue(70f, resources.getColor(R.color.chart_value_1)));
                //values.add(new FitChartValue(20f, resources.getColor(R.color.chart_value_2)));
                //values.add(new FitChartValue(15f, resources.getColor(R.color.chart_value_3)));
                //values.add(new FitChartValue(10f, resources.getColor(R.color.chart_value_4)));
                fitChart1.setValues(values);


    }
}
