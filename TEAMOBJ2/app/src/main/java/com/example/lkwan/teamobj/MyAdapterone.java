package com.example.lkwan.teamobj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapterone extends BaseAdapter {
    Context context;
    List<MyoneBean.DataBean> list;
    public  MyAdapterone(Context context, List<MyoneBean.DataBean> list){
        this.context=context;
        this.list=list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get( i );
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View contnt, ViewGroup viewGroup) {
        if (contnt==null){
            contnt= LayoutInflater.from( context ).inflate( R.layout.wangtian,viewGroup,false );

        }
        MyoneBean.DataBean myone=list.get( i );
       TextView text1= contnt.findViewById( R.id.text1 );
        TextView text2= contnt.findViewById( R.id.text2 );
        TextView text3= contnt.findViewById( R.id.text3);
        TextView text4= contnt.findViewById( R.id.text4 );
        text1.setText( myone.id+"" );
        text2.setText( myone.red+"" );
        text3.setText( myone.yellow+"" );
        text4.setText( myone.green+"" );

        return contnt;
    }
}
