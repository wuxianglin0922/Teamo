package com.example.lkwan.teamobj;

import java.util.List;

public class MyoneBean {

    /**
     * code : 1
     * data : [{"id":1,"red":5,"green":15,"yellow":19},{"id":2,"red":20,"green":8,"yellow":6},{"id":3,"red":17,"green":12,"yellow":17},{"id":4,"red":14,"green":7,"yellow":17},{"id":5,"red":18,"green":4,"yellow":15}]
     */

    public int code;
    public List <DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * red : 5
         * green : 15
         * yellow : 19
         */

        public int id;
        public int red;
        public int green;
        public int yellow;
    }
}
