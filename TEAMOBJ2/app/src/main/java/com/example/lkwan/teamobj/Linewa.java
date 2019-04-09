package com.example.lkwan.teamobj;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class Linewa extends  MyFragrmetw {
    BarChart barChart;
    @Override
    protected int getLayout() {
        return R.layout.lannv;
    }

    @Override
    public void initView(View view, Bundle savetablewfa) {

        barChart= view.findViewById( R.id.barchar );
        List<BarEntry> list=new ArrayList<>(  );
        List<String>    data=new ArrayList <>(  );
        list.add( new BarEntry( new float[]{21f,21f},0 ) );
        list.add( new BarEntry( new float[]{31f,41f},1 ) );


        data.add( "女生" );
        data.add( "男生" );

        barChart.getAxisLeft().setDrawAxisLine( true );
        XAxis xAxis=barChart.getXAxis();
        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        xAxis.setDrawGridLines( false );
        xAxis.setDrawAxisLine( true );
        barChart.setScaleEnabled( true );
        barChart.setDragEnabled( true );
        barChart.setTouchEnabled( true);

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
        barDataSet.setBarSpacePercent( 40f );

        barChart.invalidate();

    }
}
