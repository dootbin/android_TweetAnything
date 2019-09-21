package bmiles.cvtc.android_final_bmiles.lib.dao;

import android.content.Context;

import bmiles.cvtc.android_final_bmiles.lib.sqlite.Helper;


public class Base {

    protected Context context;
    protected Helper dbHelper;

    public Base(Context context) {

        this.context = context;
        this.dbHelper = new Helper(context);


    }


    public Helper getDbHelper() {

        return this.dbHelper;
    }




}
