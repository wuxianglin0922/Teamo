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

public class Tiandangli extends     MyFragrmetw {
    PieChart pieChart;

    @Override
    protected int getLayout() {
        return R.layout.tian;
    }

    @Override
    public void initView(View view, Bundle savetablewfa) {

        pieChart= view.findViewById( R.id.wangiz  );

        List<Entry> list=new ArrayList<>(  );
        list.add(new Entry( 71.60f,0   ));
        list.add(new Entry( 28.40f,1   ));
        final List<String> dara=new ArrayList <>(  );
        dara.add( "第一天");
        dara.add( "第二天");



        PieDataSet pieDataSet=new PieDataSet( list,"我的第二个" );
        pieDataSet.setSliceSpace( 5f );
        pieDataSet.setSelectionShift( 5f );

        pieDataSet.setColors( new int[]{Color.RED,Color.YELLOW} );

        PieData pieData=new PieData( dara,pieDataSet  );
        pieData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return dara.get(entry.getXIndex()) + ":" + entry.getVal()+"%";
            }
        });
        pieData.setDrawValues( true );
        pieChart.setDrawHoleEnabled( false );
        pieChart.setData( pieData );
        pieChart.invalidate();
        //initData();

    }
}
