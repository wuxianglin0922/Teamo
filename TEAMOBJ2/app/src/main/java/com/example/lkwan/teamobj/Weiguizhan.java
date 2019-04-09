package com.example.lkwan.teamobj;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class Weiguizhan extends  MyFragrmetw {
    HorizontalBarChart horizontalBarChart;
    @Override
    protected int getLayout() {
        return R.layout.weiguizhan;
    }

    @Override
    public void initView(View view, Bundle savetablewfa) {
        horizontalBarChart= view.findViewById( R.id.suiping );
        List<BarEntry> list=new ArrayList<>(  );
        final List<String>  data=new ArrayList <>(  );
        list.add( new BarEntry( 30,0 ) );
        list.add( new BarEntry( 15,1 ) );
        list.add( new BarEntry( 3,2 ) );
        list.add( new BarEntry( 3,3 ) );
        list.add( new BarEntry( 3,4 ) );
        list.add( new BarEntry( 3,5) );
        list.add( new BarEntry( 3,6 ) );
        list.add( new BarEntry( 3,7 ) );
        list.add( new BarEntry( 3,8 ) );
        list.add( new BarEntry( 3,9 ) );


        data.add( "超神行驶" );
        data.add( "5条以上违规" );
        data.add( "5条以上违规" );
        data.add( "5条以上违规" );
        data.add( "5条以上违规" );
        data.add( "5条以上违规" );
        data.add( "5条以上违规" );
        data.add( "5条以上违规" );
        data.add( "3-5条违规" );
        data.add( "1-2条违规" );
        XAxis xAxis=horizontalBarChart.getXAxis();
        xAxis.setDrawAxisLine( true );
        xAxis.setDrawGridLines( false );
        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        horizontalBarChart.setDrawGridBackground( false );
        horizontalBarChart.getAxisLeft().setDrawAxisLine( true );
        horizontalBarChart.setDragEnabled( true );
        horizontalBarChart.setTouchEnabled( true );
        horizontalBarChart.setScaleEnabled( true );
        horizontalBarChart.getAxisLeft().setEnabled( false );
        horizontalBarChart.getAxisRight().setEnabled( true );
        BarDataSet barDataSet=new BarDataSet(list,"违规车辆的违规次数"  );
        barDataSet.setColors( new int[]{Color.BLUE,Color.RED,Color.BLACK} );
        barDataSet.setBarSpacePercent( 70f );
        barDataSet.setValueFormatter( new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return entry.getVal()+"%";
            }
        } );
        BarData barData=new BarData( data,barDataSet );
        horizontalBarChart.setData( barData );
        horizontalBarChart.animateY( 1000 );
        horizontalBarChart.invalidate();
    }
}
