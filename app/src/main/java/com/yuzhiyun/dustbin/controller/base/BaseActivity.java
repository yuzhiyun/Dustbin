package com.yuzhiyun.dustbin.controller.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.yuzhiyun.dustbin.R;
import butterknife.ButterKnife;

/**
 * Created by yuzhiyun on 2016-10-09.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context context;
    public Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        //设置layout
        setLayoutView();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        initOther();

    }
    protected abstract void setLayoutView();
    protected abstract void initOther();

}

