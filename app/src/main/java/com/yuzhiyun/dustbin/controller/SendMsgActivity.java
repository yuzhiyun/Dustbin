package com.yuzhiyun.dustbin.controller;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.yuzhiyun.dustbin.R;
import com.yuzhiyun.dustbin.controller.base.BaseActivity;
import com.yuzhiyun.dustbin.model.Application.App;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class SendMsgActivity extends BaseActivity {

    String urlSave = "http://" + App.ip + "/save.msg";
    String urlFindAll = "http://" + App.ip + "/findAll.msg";

    @Bind(R.id.etMsg)
    EditText etMsg;


    @Bind(R.id.btnSend)
    Button btnSend;


    @Bind(R.id.img)
    ImageView img;


    @Bind(R.id.imgHouse)
    ImageView imgHouse;

    @Bind(R.id.imgMoney)
    ImageView imgMoney;

    @Bind(R.id.imgCar)
    ImageView imgCar;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_send_msg);
    }

    @Override
    protected void initOther() {
        getSupportActionBar().setTitle("吐槽");
        Animation animation=AnimationUtils.loadAnimation(context,R.anim.rotate);
        //旋转匀速
        LinearInterpolator lir = new LinearInterpolator();
        animation.setInterpolator(lir);
        img.startAnimation(animation);
        imgHouse.startAnimation(animation);

        Animation animation2=AnimationUtils.loadAnimation(context,R.anim.rotate);
        animation2.setInterpolator(lir);
        imgCar.startAnimation(animation2);
        imgMoney.startAnimation(animation2);
    }

    @OnClick(R.id.btnSend)
    public void btnSend(){
//        startActivity(new Intent(context,MainActivity.class));
        save(urlSave);
    }


    /**
     * 发送弹幕给服务器
     * @param url
     */
    private void save(String url) {
        //        进度对话框
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("正在发送弹幕...");
        progressDialog.show();
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    public void onResponse(String s) {
                        progressDialog.dismiss();
//                        Log.i("登录onResponse", s);
                  if("success".equals(s))
                      Toast.makeText(SendMsgActivity.this, "发送弹幕成功", Toast.LENGTH_SHORT).show();
//                        弹出对话框询问是否进入小黑屋查看所有弹幕
                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setMessage("进入小黑屋逛一逛");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                findAll(urlFindAll);
                            }
                        });
                        builder.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(SendMsgActivity.this, "失败"+volleyError.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put("Message", etMsg.getText().toString().trim());
                return map;
            }
        };
        App.getRequestQueue(context).add(request);
    }

    /**
     *获取所有弹幕
     * @param url
     */
    private void findAll(String url) {
        //        进度对话框
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("正在获取弹幕...");
        progressDialog.show();
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    public void onResponse(String s) {
                        progressDialog.dismiss();
//                        Log.i("登录onResponse", s);
                            Toast.makeText(SendMsgActivity.this, "成功获取弹幕"+s, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(SendMsgActivity.this, "失败"+volleyError.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put("Message", etMsg.getText().toString().trim());
                return map;
            }
        };
        App.getRequestQueue(context).add(request);

    }

}
