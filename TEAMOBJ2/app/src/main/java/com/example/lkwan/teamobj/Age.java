package com.example.lkwan.teamobj;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class Age extends MyFragrmetw {
    BarChart barChart;
    @Override
    protected int getLayout() {
        return R.layout.age;
    }

    @Override
    public void initView(View view, Bundle savetablewfa) {
    barChart= view.findViewById( R.id.barchar );
        List<BarEntry> list=new ArrayList <>(  );
        List<String>    data=new ArrayList <>(  );
        List<BarEntry> wangz=new ArrayList <>(  );

        list.add( new BarEntry( new float[]{21f,21f},0 ) );
        list.add( new BarEntry( new float[]{31f,41f},1 ) );
        list.add( new BarEntry( new float[]{51f,61f},2 ) );
        list.add( new BarEntry( new float[]{41f,41f},3 ) );
        list.add( new BarEntry( new float[]{51f,21f},4 ) );
        data.add( "90后" );
        data.add( "80后" );
        data.add( "70后" );
        data.add( "60后" );
        data.add( "50后" );
        barChart.getAxisLeft().setDrawAxisLine( true );
        XAxis xAxis=barChart.getXAxis();
        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        xAxis.setDrawGridLines( false );
        xAxis.setDrawAxisLine( true );
        barChart.setScaleEnabled( true );
        barChart.setDragEnabled( true );
        barChart.setTouchEnabled( true);
        YAxis yAxis=barChart.getAxisLeft();

        BarDataSet barDataSet =new BarDataSet( list,"" );
        barChart.getAxisLeft().setEnabled( true );
        barChart.getAxisRight().setEnabled( false );

        barDataSet.setColors( new int[]{Color.BLACK,Color.RED,Color.BLUE,Color.YELLOW,Color.BLACK,Color.LTGRAY,Color.GRAY,Color.DKGRAY,Color.GRAY} );
        barDataSet.setValueFormatter( new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return entry.getVal()+"%";
            }
        } );
        BarData barData=new BarData( data,barDataSet );
        barChart.animateY( 1000 );
        barChart.setData( barData );
        barDataSet.setBarSpacePercent( 70f );

        barChart.invalidate();

     }
}
