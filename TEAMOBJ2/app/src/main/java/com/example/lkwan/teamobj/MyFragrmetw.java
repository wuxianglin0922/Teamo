package com.example.lkwan.teamobj;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class MyFragrmetw extends Fragment {
    protected  abstract int getLayout();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate( getLayout(),container,false );
  initView(  view,savedInstanceState );
        return view;
    }
    public  abstract void  initView(View view,Bundle savetablewfa);
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public  void  inieredata(int contentid,Fragment fragment){
        fragmentManager=getFragmentManager();
         fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace( contentid,fragment );
        fragmentTransaction.commit();
    }
    public  void  indataview(Fragment fragment){
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        if (fragment!=null){
            fragmentTransaction.remove( fragment );
            fragmentTransaction.commit();
        }
    }
}
