package com.example.lkwan.teamobj;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;



public class ListPall extends Activity {
    Button button;
    Spinner spinner;
    int position=0;
    MyoneBean myoneBean;
    MyAdapterone myAdapterone;
    ListView listView;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.tiandao );
//https://easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/lamplist
      button= findViewById( R.id.btn );
     spinner= findViewById( R.id.sping );
   listView= findViewById( R.id.wang );
   initData();
   initValues();
    }
    public  void  initValues(){
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> adapterView, View view, int position, long l) {
                ListPall.this.position=position;
            }

            @Override
            public void onNothingSelected(AdapterView <?> adapterView) {

            }
        } );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListpai(position);
            }
        } );
    }
    public  void  getListpai(int i){
        switch (i){
            case 0:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.id<t2.id){
                            return -1;
                        }else if (t1.id>t2.id){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
            case 1:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.id>t2.id){
                            return -1;
                        }else if (t1.id<t2.id){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
            case 2:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.red<t2.red){
                            return -1;
                        }else if (t1.red>t2.red){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
            case 3:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.red>t2.red){
                            return -1;
                        }else if (t1.red<t2.red){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
            case 4:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.yellow<t2.yellow){
                            return -1;
                        }else if (t1.yellow>t2.yellow){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
            case 5:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.yellow>t2.yellow){
                            return -1;
                        }else if (t1.yellow<t2.yellow){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
            case 6:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.green<t2.green){
                            return -1;
                        }else if (t1.green>t2.green){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
            case 7:
                Collections.sort( myoneBean.data, new Comparator <MyoneBean.DataBean>() {
                    @Override
                    public int compare(MyoneBean.DataBean t1, MyoneBean.DataBean t2) {
                        if (t1.green>t2.green){
                            return -1;
                        }else if (t1.green<t2.green){
                            return 1;
                        }
                        return 0;
                    }
                } );
                break;
        }
        myAdapterone.notifyDataSetChanged();
    }
    public void  initData(){
        OkHttpClient okHttpClient=new OkHttpClient();
        final MediaType mediaType=MediaType.parse( "application/json; charset=utf-8" );
        Request request=new Request.Builder().url( "https://easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/lamplist" ).post( RequestBody.create( mediaType,"" ) ).build();
        okHttpClient.newCall(  request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String body=   response.body().string();
                Message message=new Message();
                message.what=1;
                message.obj=body;
                handler.sendMessage( message );
            }
        });



    }
    public Handler handler=new Handler(  ){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            switch (msg.what){
                case  1:
              String body= (String) msg.obj;
                    Gson gson=new Gson();
                 myoneBean=    gson.fromJson( body,MyoneBean.class );
                 myAdapterone=new MyAdapterone( ListPall.this,myoneBean.data );
                listView.setAdapter( myAdapterone );
                    break;
            }
        }
    };
}
