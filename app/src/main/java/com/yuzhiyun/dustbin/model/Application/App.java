package com.yuzhiyun.dustbin.model.Application;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yuzhiyun on 2016-10-11.
 */
public class App  extends Application{

    public static RequestQueue requestQueue = null;

    public static String ip = "123.207.240.183:8080/barrage";
//    public static String ip = "192.168.1.104:8080";
    public static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);
        return requestQueue;
    }

}
