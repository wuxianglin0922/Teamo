package com.example.lkwan.teamobj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MyBarlin extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.line );
      ViewPager viewPager= findViewById( R.id.wangzhe );
        List<Fragment> list=new ArrayList <>(  );
        list.add( new Mybar() );
        list.add( new Tiandangli() );
        list.add( new Barchartw() );
        list.add( new Age() );
        list.add( new Linewa() );
        list.add( new Weigui() );
        list.add( new Weiguizhan() );
        MyPieAdapter myPieAdapter=new MyPieAdapter( getSupportFragmentManager(),list );
      viewPager.setAdapter( myPieAdapter );
    }
}
