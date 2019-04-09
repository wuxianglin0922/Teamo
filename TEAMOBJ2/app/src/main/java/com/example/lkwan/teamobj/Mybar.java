package com.example.lkwan.teamobj;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class Mybar extends  MyFragrmetw {
    PieChart pieChart;
    @Override
    protected int getLayout() {
        return R.layout.mybar;
    }

    @Override
    public void initView(View view, Bundle savetablewfa) {
        pieChart= view.findViewById( R.id.wangzit );

        List<Entry> list=new ArrayList<>(  );
        list.add(new Entry( 71.60f,0   ));
        list.add(new Entry( 28.40f,1   ));
        final List<String> dara=new ArrayList <>(  );
        dara.add( "有违规");
        dara.add( "无违规");


        PieDataSet pieDataSet=new PieDataSet( list,"" );

        pieDataSet.setSliceSpace( 5f );
        pieDataSet.setSelectionShift( 5f );

        pieDataSet.setColors( new int[]{Color.RED,Color.YELLOW} );

        PieData pieData=new PieData( dara,pieDataSet  );

        pieData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return   entry.getVal()+"%";
            }
        });
        pieData.setDrawValues( false );
        pieChart.setDrawHoleEnabled( false );
        pieChart.setData( pieData );
        pieChart.invalidate();



    }
}
