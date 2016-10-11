package com.yuzhiyun.dustbin.view.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.yuzhiyun.dustbin.model.TextData;

import java.util.ArrayList;
import java.util.Random;

public class BrrrageView extends BaseView {

    private ArrayList<BrrrageItem> list = new ArrayList<BrrrageItem>();
    private int rainNum = 30;
    private int size = 30;
    private int mTextColor;
    private String text;

    public BrrrageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BrrrageView(Context context) {
        super(context);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        for (BrrrageItem item : list) {
            item.draw(canvas);
        }
    }

    /**
     *
     */
    @Override
    protected void logic() {
        for (BrrrageItem item : list) {
            item.move();
        }
    }

    @Override
    protected void init() {
         Random random=new Random();

        //颜色随机
//        paint.setColor(TextData.colors[r]);
        for (int i = 0; i < rainNum; i++) {
            //颜色
            int r1=random.nextInt(TextData.colors.length);
            mTextColor=TextData.colors[r1];
//            文字内容
            int r2=random.nextInt(TextData.texts.length);
            text=TextData.texts[r2];
//            大小
            int r3=random.nextInt(20);
            r3+=40;
            size=r3;
//			RainItem item = new RainItem(getWidth(), getHeight(), size, rainColor, randColor);
            BrrrageItem item = new BrrrageItem(getWidth(), getHeight(), size, mTextColor,text);
            list.add(item);
        }
    }

}
